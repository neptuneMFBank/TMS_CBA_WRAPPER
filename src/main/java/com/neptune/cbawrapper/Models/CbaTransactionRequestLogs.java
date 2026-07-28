package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cba_transaction_debit_credit_Logs")
public class CbaTransactionRequestLogs {

    @Id
    private String id;

    private String transaction_reference;
    private String processingInstance;
    private String request;
    private String response;
    private String createdAt;
    private String updatedAt;
}
