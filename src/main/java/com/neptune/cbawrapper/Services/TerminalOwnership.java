package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.CustomersModel;
import com.neptune.cbawrapper.Models.MerchantData;
import com.neptune.cbawrapper.Models.PendingTerminalData;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * A terminal reassigned in the TMS comes back on pending-wallet-sync under its new owner while it still
 * has a virtual account here for the previous owner.
 */
public final class TerminalOwnership {

    private TerminalOwnership() {
    }

    /**
     * Whether the terminal's existing virtual account belongs to an owner other than the one pending-wallet-sync now
     * reports. Accounts created before parentSavingsId was stored are compared by the owner's account number.
     */
    public static boolean ownerChanged(VirtualAccountModel existing, PendingTerminalData pending, CustomersModel newOwner) {
        if (existing.getParentSavingsId() != null && pending.getParentSavingsId() != null) {
            return !existing.getParentSavingsId().equals(pending.getParentSavingsId());
        }
        String previousAccount = StringUtils.trimToNull(existing.getParent_account());
        String newAccount = StringUtils.trimToNull(newOwner.getAccount_num());
        return previousAccount != null && newAccount != null && !previousAccount.equals(newAccount);
    }

    /**
     * For a reassigned terminal whose new owner has no unused POS request: settle to the business account when any
     * of the owner's merchant rows says so.
     */
    public static boolean useAcct(List<MerchantData> ownerMerchants) {
        return ownerMerchants != null && ownerMerchants.stream().anyMatch(m -> Boolean.TRUE.equals(m.getUseAcct()));
    }

    /**
     * Detaches the account from the terminal. It stays with the previous owner's customer record on core banking.
     */
    public static void retire(VirtualAccountModel existing) {
        existing.setReassignedFromTerminalId(existing.getTerminalId());
        existing.setTerminalId(null);
        existing.setReassignedAt(ZonedDateTime.now().toString());
        existing.setUpdated_at(ZonedDateTime.now().toString());
    }
}
