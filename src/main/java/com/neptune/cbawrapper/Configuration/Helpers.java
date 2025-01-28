package com.neptune.cbawrapper.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.*;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.BusinessPlatformChargesRepository;
import com.neptune.cbawrapper.Repository.CbaTransactionRequestsRepository;
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
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class Helpers {

    @Value("${secret.key}")
    private String secretKey;

    @Autowired
    private CustomersRepository customersRepository;


    private final CbaTransactionRequestsRepository cbaTransactionRequests;
    private final PlatformChargeRepository platformChargeRepository;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;

    public Helpers(PlatformChargeRepository platformChargeRepository, CbaTransactionRequestsRepository cbaTransactionRequests, BusinessPlatformChargesRepository businessPlatformChargesRepository) {
        this.platformChargeRepository = platformChargeRepository;
        this.businessPlatformChargesRepository = businessPlatformChargesRepository;
        this.cbaTransactionRequests = cbaTransactionRequests;
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

    public <T> String encryptObject(String jsonString) {
        try {
            // Step 2: Encrypt the JSON string
            return AesUtil.encrypt(jsonString, secretKey);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting object", e);
        }
    }

    public TransactionDrCr saveTransaction(String parent_id, String posRef, String Transactiontype, String accountName, String account, String card_scheme, String platform_id, int resourceId, String response_code, String drcr, String narration, String terminalId, Double amount, String reference, String type, String cba_message, boolean isUpdated){
        if(type.equals("create")) {
            TransactionDrCr transactionDrCr = new TransactionDrCr();
            transactionDrCr.setAccountnumber(account);
            transactionDrCr.setIsccode("2");
            transactionDrCr.setAccountstatus("active");
            transactionDrCr.setUpdatedToCba(false);
            transactionDrCr.setType(Transactiontype);
            transactionDrCr.setTerminalId(terminalId);
            transactionDrCr.setAcctname(accountName);
            transactionDrCr.setDrcr(drcr);
            transactionDrCr.setAcctype("savings");
            transactionDrCr.setAmount(amount);
            transactionDrCr.setTransactionreference(reference);
            transactionDrCr.setNarration(narration);
            transactionDrCr.setChannel("1");
            transactionDrCr.setPosRef(posRef);
            transactionDrCr.setResponseCode(response_code);
            transactionDrCr.setEid("");
            transactionDrCr.setParent_id(parent_id);
            transactionDrCr.setCbaMessage(cba_message);
            transactionDrCr.setResourceId(resourceId);
            transactionDrCr.setTransaction_platform_id(platform_id);
            transactionDrCr.setCardScheme(card_scheme);
            transactionDrCr.setCreated_at(LocalDateTime.now());
            transactionDrCr.setUpdated_at(LocalDateTime.now());
            cbaTransactionRequests.save(transactionDrCr);
            return transactionDrCr;
        }else {
            Optional<TransactionDrCr> transactionDrCr = cbaTransactionRequests.findByRef(reference);

            if(transactionDrCr.isEmpty()){
                return null;
            }

            transactionDrCr.get().setCbaMessage(cba_message);
            transactionDrCr.get().setUpdatedToCba(isUpdated);
            cbaTransactionRequests.save(transactionDrCr.get());
            return transactionDrCr.get();
        }
    }

    public String generateId(String terminalId){
        return "pos_" + terminalId + "_" +  System.currentTimeMillis();
    }

    public String generateTransactId(String terminalId, String ref){
        return "pos_" + terminalId + "_" + ref + "_" + System.currentTimeMillis();
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

    public boolean isAuthTokenValid(String authToken, String verifyUser){
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
