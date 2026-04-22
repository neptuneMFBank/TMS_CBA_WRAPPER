package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DisputeRequest {
    private String transactionId;
    private String terminalId;
    private String disputeReason;
    private String otherReason;
    private String note;

    @Override
    public String toString() {
        return "DisputeRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", disputeReason='" + disputeReason + '\'' +
                ", otherReason='" + otherReason + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
