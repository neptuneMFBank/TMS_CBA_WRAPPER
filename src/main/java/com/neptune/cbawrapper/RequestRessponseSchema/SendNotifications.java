package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendNotifications {
        private String title;
        private String message;
        private String receiverFcmToken;
        private boolean pushNotify;
        private String file;
        private String receiver_email;
        private boolean sendmail;
        private boolean attachment;

        public String getTitle() {
                return title;
        }

        public String getMessage() {
                return message;
        }

        public String getReceiverFcmToken() {
                return receiverFcmToken;
        }

        public boolean isPushNotify() {
                return pushNotify;
        }

        public String getFile() {
                return file;
        }

        public String getReceiver_email() {
                return receiver_email;
        }

        public boolean isSendmail() {
                return sendmail;
        }

        public boolean isAttachment() {
                return attachment;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public void setReceiverFcmToken(String receiverFcmToken) {
                this.receiverFcmToken = receiverFcmToken;
        }

        public void setFile(String file) {
                this.file = file;
        }

        public void setPushNotify(boolean pushNotify) {
                this.pushNotify = pushNotify;
        }

        public void setReceiver_email(String receiver_email) {
                this.receiver_email = receiver_email;
        }

        public void setSendmail(boolean sendmail) {
                this.sendmail = sendmail;
        }

        public void setAttachment(boolean attachment) {
                this.attachment = attachment;
        }
}
