package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Dispute {
    private String refNo;
    private String terminalSerialNo;
    private String disputeReason;
    private String otherReason;
    private String note;
    private String type;

    public String getRefNo() {
        return refNo;
    }

    public String getDisputeReason() {
        return disputeReason;
    }

    public String getOtherReason() {
        return otherReason;
    }

    public String getNote() {
        return note;
    }

    public String getTerminalSerialNo() {
        return terminalSerialNo;
    }

    public String getType() {
        return type;
    }
}
