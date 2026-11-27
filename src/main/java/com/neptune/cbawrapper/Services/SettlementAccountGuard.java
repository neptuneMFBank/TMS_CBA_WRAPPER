package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.RequestRessponseSchema.TerminalProfile;
import org.apache.commons.lang3.StringUtils;

/**
 * Merchants can only transfer outwards to their settlement account, which the TMS returns in the
 * terminal's settings. Other terminals (agents) are not restricted.
 */
public final class SettlementAccountGuard {

    private static final String MERCHANT = "MERCHANT";

    private SettlementAccountGuard() {
    }

    /**
     * Returns why the transfer must be blocked, or null if it may go ahead.
     *
     * @param profile         the terminal's profile from the TMS settings endpoint
     * @param terminalId      the terminal ID on the transaction request
     * @param destAccount     the name enquiry's destination account number
     * @param destBankCode    the name enquiry's destination institution code
     */
    public static String blockReason(TerminalProfile profile, String terminalId, String destAccount, String destBankCode) {
        if (profile == null) {
            return "Could not verify this terminal's settlement account, kindly try again";
        }
        if (!StringUtils.equalsIgnoreCase(StringUtils.trim(profile.getTerminalId()), StringUtils.trim(terminalId))) {
            return "Terminal details do not match this terminal";
        }
        if (!MERCHANT.equalsIgnoreCase(StringUtils.trim(profile.getEntityType()))) {
            return null;
        }
        if (StringUtils.isAnyBlank(profile.getSettlementAcct(), profile.getSettlementBankCode())) {
            return "Add a settlement account before making transfers";
        }
        boolean toSettlement = StringUtils.equals(StringUtils.trim(profile.getSettlementAcct()), StringUtils.trim(destAccount))
                && StringUtils.equals(StringUtils.trim(profile.getSettlementBankCode()), StringUtils.trim(destBankCode));
        return toSettlement ? null : "Merchants can only transfer to their settlement account";
    }
}
