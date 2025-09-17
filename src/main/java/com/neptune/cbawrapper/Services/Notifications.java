package com.neptune.cbawrapper.Services;

import auth.AuthServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.RequestRessponseSchema.SendNotifications;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import notification_service.NotificationServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class Notifications {

    private final ErrorLoggingException errorLoggingException;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${grpc.notifications.url}")
    private String notif_server_ip;

    @Value("${grpc.notifications.port}")
    private int notif_server_port;

    public notification_service.Notifications.NotificationResponse sendNotification(SendNotifications notif) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(notif_server_ip, notif_server_port).usePlaintext().build();
        notification_service.Notifications.NotificationResponse response = null;
        try {
            notification_service.Notifications.NotificationRequest request = notification_service.Notifications.NotificationRequest.newBuilder()
                    .setTitle(notif.getTitle())
                    .setMessage(notif.getMessage())
                    .setIcon("")
                    .setNotificationType("")
                    .setMessagePriority("1")
                    .setReceiverPhoneNumber("")
                    .setReceiverPhoneCountry("")
                    .setReceiverEmail(notif.getReceiver_email())
                    .setReceiverFcmToken(
                            notif.getReceiverFcmToken()
                    )
                    .setFile(notif.getFile())
                    .setReceiverSocketId("")
                    .setAttachment(notif.isAttachment())
                    .setFile("")
                    .setWebhook(notification_service.Notifications.WebHook.newBuilder()
                            .setEvent("Transaction notification")
                            .setUrl("")
                            .setPayload("")
                            .build()
                    )
                    .setSendmail(notif.isSendmail())
                    .setSendtext(false)
                    .setSendwebhook(false)
                    .setPushNotify(true)
                    .setExtensiontype("")
                    .build();

            NotificationServiceGrpc.NotificationServiceBlockingStub stub = NotificationServiceGrpc.newBlockingStub(channel);
            response = stub.notify(request); //connection().create3ppUser(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("GET_USER_PHONE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("GET_USER_PHONE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } finally {
            channel.shutdownNow();
        }
        return response;
    }
}
