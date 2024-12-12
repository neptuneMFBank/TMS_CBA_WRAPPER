package com.neptune.cbawrapper.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.*;
import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.Models.CustomersModel;
import com.neptune.cbawrapper.Models.PlatformCharges;
import com.neptune.cbawrapper.Models.VerifyUser;
import com.neptune.cbawrapper.Repository.BusinessPlatformChargesRepository;
import com.neptune.cbawrapper.Repository.CustomersRepository;
import com.neptune.cbawrapper.Repository.PlatformChargeRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.CorepayPosTransactionRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class Helpers {

    @Value("${secret.key}")
    private String secretKey;

    @Autowired
    private CustomersRepository customersRepository;


    private final PlatformChargeRepository platformChargeRepository;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;

    public Helpers(PlatformChargeRepository platformChargeRepository, BusinessPlatformChargesRepository businessPlatformChargesRepository) {
        this.platformChargeRepository = platformChargeRepository;
        this.businessPlatformChargesRepository = businessPlatformChargesRepository;
    }

    public List<CustomersModel> getCustomersBySavingsId(List<Integer> details) {
        // Fetch customers matching savings IDs
        return customersRepository.findBySavingsId(details);
    }


    public <T> String encryptObject(T object) {
        try {
            // Step 1: Serialize the object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(object);

            // Step 2: Encrypt the JSON string
            return AesUtil.encrypt(jsonString, secretKey);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting object", e);
        }
    }

    public <T> T decryptObject(String encryptedString, Class<T> clazz) {
        try {
            // Step 3: Decrypt the encrypted string
            String decryptedJson = AesUtil.decrypt(encryptedString, secretKey);

            // Step 4: Deserialize the JSON string back to the object
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(decryptedJson, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting object", e);
        }
    }

    public boolean isAuthTokenValid(String authToken, CorepayPosTransactionRequest verifyUser){
        String encryptedData = this.encryptObject(verifyUser);

        System.out.println("encryptedData = " + encryptedData);
        return encryptedData.equals(authToken);
    }

    public Page<PlatformCharges> getPaginatedPlatformCharges(int page, int size){
        Pageable pageable = PageRequest.of(page, size); // page is 0-indexed
        return platformChargeRepository.findAll(pageable);
    }

    public Page<BusinessPlatformCharges> getPaginatedBusinessPlatformCharges(int page, int size){
        Pageable pageable = PageRequest.of(page, size); // page is 0-indexed
        return businessPlatformChargesRepository.findAll(pageable);
    }

    public String convertToJson(Object data){
        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter()).create();
        return gson.toJson(data);
    }

    public <T> T convertToObject(String data, Class<T> object) {
        Gson gson = new Gson();
        return gson.fromJson(data, object);
    }

    static class ZonedDateTimeAdapter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        @Override
        public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.format(formatter));
        }

        @Override
        public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return ZonedDateTime.parse(json.getAsString(), formatter);
        }
    }

//    public void sendNotification(String token, String title, String body){
//        try {
//            Message message = Message.builder()
//                    .setToken(token)
//                    .setNotification(Notification.builder()
//                            .setTitle(title)
//                            .setBody(body)
//                            .build())
//                    .build();
//
//            String response = FirebaseMessaging.getInstance().send(message);
//            System.out.println("Notification sent: " + response);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
