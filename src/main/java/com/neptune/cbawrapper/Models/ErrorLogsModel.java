package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "error_logs")
public class ErrorLogsModel {

    @Id
    private String id;
    private String desc;
    private String type;
    private String status_code;
    private String identifier;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public ErrorLogsModel(Throwable cause, String message) {
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ErrorLogsModel(String identifier, String desc) {
        this.identifier = identifier;
        this.desc = desc;
    }

    public ErrorLogsModel(String id, String desc, String type, String status_code, String identifier) {
        this.id = id;
        this.desc = desc;
        this.type = type;
        this.status_code = status_code;
        this.identifier = identifier;
    }
}
