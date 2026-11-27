package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.CustomersModel;
import com.neptune.cbawrapper.Models.PendingTerminalData;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.neptune.cbawrapper.RequestRessponseSchema.TerminalProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettlementAndReassignmentTest {

    private static TerminalProfile profile(String entityType, String acct, String bankCode) {
        TerminalProfile profile = new TerminalProfile();
        profile.setTerminalId("2NEP0001");
        profile.setEntityType(entityType);
        profile.setSettlementAcct(acct);
        profile.setSettlementBankCode(bankCode);
        return profile;
    }

    @Test
    void merchantsCanOnlyTransferToTheirSettlementAccount() {
        TerminalProfile merchant = profile("MERCHANT", "0123456789", "090329");
        assertNull(SettlementAccountGuard.blockReason(merchant, "2NEP0001", "0123456789", "090329"));
        assertNotNull(SettlementAccountGuard.blockReason(merchant, "2NEP0001", "9999999999", "090329"));
        assertNotNull(SettlementAccountGuard.blockReason(merchant, "2NEP0001", "0123456789", "058063"));
    }

    @Test
    void merchantsWithoutASettlementAccountCannotTransfer() {
        assertEquals("Add a settlement account before making transfers",
                SettlementAccountGuard.blockReason(profile("MERCHANT", null, null), "2NEP0001", "0123456789", "090329"));
    }

    @Test
    void agentsAreNotRestricted() {
        assertNull(SettlementAccountGuard.blockReason(profile("AGENT", null, null), "2NEP0001", "9999999999", "058063"));
    }

    @Test
    void unverifiableOrMismatchedTerminalsAreBlocked() {
        assertNotNull(SettlementAccountGuard.blockReason(null, "2NEP0001", "0123456789", "090329"));
        assertEquals("Terminal details do not match this terminal",
                SettlementAccountGuard.blockReason(profile("AGENT", null, null), "2NEP9999", "0123456789", "090329"));
    }

    @Test
    void ownerChangeIsSpottedBySavingsIdOrForOldAccountsByParentAccount() {
        PendingTerminalData pending = new PendingTerminalData();
        pending.setParentSavingsId(30);
        CustomersModel newOwner = new CustomersModel();
        newOwner.setAccount_num("6000000030");

        VirtualAccountModel sameOwner = new VirtualAccountModel();
        sameOwner.setParentSavingsId(30);
        assertFalse(TerminalOwnership.ownerChanged(sameOwner, pending, newOwner));

        VirtualAccountModel otherOwner = new VirtualAccountModel();
        otherOwner.setParentSavingsId(20);
        assertTrue(TerminalOwnership.ownerChanged(otherOwner, pending, newOwner));

        VirtualAccountModel legacy = new VirtualAccountModel();
        legacy.setParent_account("6000000020");
        assertTrue(TerminalOwnership.ownerChanged(legacy, pending, newOwner));
        legacy.setParent_account("6000000030");
        assertFalse(TerminalOwnership.ownerChanged(legacy, pending, newOwner));

        VirtualAccountModel unknown = new VirtualAccountModel();
        assertFalse(TerminalOwnership.ownerChanged(unknown, pending, newOwner));
    }

    @Test
    void reassignedTerminalSettlesToTheBusinessAccountOnlyIfTheNewOwnerDoes() {
        com.neptune.cbawrapper.Models.MerchantData usesBusinessAcct = new com.neptune.cbawrapper.Models.MerchantData();
        usesBusinessAcct.setUseAcct(true);
        assertTrue(TerminalOwnership.useAcct(java.util.List.of(new com.neptune.cbawrapper.Models.MerchantData(), usesBusinessAcct)));
        assertFalse(TerminalOwnership.useAcct(java.util.List.of()));
        assertFalse(TerminalOwnership.useAcct(null));
    }

    @Test
    void retiringDetachesTheAccountFromTheTerminal() {
        VirtualAccountModel account = new VirtualAccountModel();
        account.setTerminalId("2NEP0001");
        TerminalOwnership.retire(account);
        assertNull(account.getTerminalId());
        assertEquals("2NEP0001", account.getReassignedFromTerminalId());
        assertNotNull(account.getReassignedAt());
    }
}
