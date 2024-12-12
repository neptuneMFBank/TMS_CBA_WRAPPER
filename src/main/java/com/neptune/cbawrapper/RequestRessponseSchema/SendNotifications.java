package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class SendNotifications {
        private String title;
        private String message;
        private String receiverFcmToken;
        private boolean pushNotify;

    }
