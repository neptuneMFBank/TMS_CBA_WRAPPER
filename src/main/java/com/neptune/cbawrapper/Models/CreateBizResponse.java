package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateBizResponse {
    private boolean status;
    private BizResponseData data;
    private String message;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BizResponseData getData() {
        return data;
    }

    public void setData(BizResponseData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BizResponseData {
        private String message;
        private int code;

        public BizResponseData() {}

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "BizResponseData{" +
                    "message='" + message + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CreateBizResponse{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
