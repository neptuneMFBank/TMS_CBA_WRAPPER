package com.neptune.cbawrapper.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cbawrapper.RequestRessponseSchema.DebitCreditData;
import com.neptune.cbawrapper.RequestRessponseSchema.PushyPushRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.WebHookRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PushyAPI {
    public static ObjectMapper mapper = new ObjectMapper();

    // Insert your Secret API Key here
    @Value("${pushy.secret}")
    public String SECRET_API_KEY;

    @Value("${pushy.url}")
    public String SECRET_API_URL;

    public void sendPush(String token, DebitCreditData request) throws Exception {
        // Prepare list of target device tokens
        List<String> deviceTokens = new ArrayList<>();

        System.out.println("token = " + token);

        // Add your device tokens here
        deviceTokens.add(token);

        // Convert to String[] array
        String[] to = deviceTokens.toArray(new String[deviceTokens.size()]);

        // Optionally, send to a publish/subscribe topic instead
        // String to = '/topics/news';

        // Set payload (any object, it will be serialized to JSON)
        Map<String, String> payload = new HashMap<>();

        String message = "Successfully received " + request.getAmount() + " from " + request.getSourceAccountName();

        // Add "message" parameter to payload
        payload.put("message", message);

        // iOS notification fields
        Map<String, Object> notification = new HashMap<>();
        String json = mapper.writeValueAsString(request);

        notification.put("badge", 1);
        notification.put("sound", "ping.aiff");
        notification.put("title", "Test Notification");
        notification.put("body", json);

        // Prepare the push request
        PushyPushRequest push = new PushyPushRequest(payload, to, notification);

        System.out.println("push = " + push.toString());
        try {
            // Try sending the push notification
            sendPushNotification(push);
        }
        catch (Exception exc) {
            System.out.println("ERROR = " + exc.getMessage());
            // Error, print to console
            System.out.println(exc.toString());
        }
    }

    public void sendPushNotification(PushyPushRequest req) throws Exception {
        // Get custom HTTP client
        HttpClient client = new DefaultHttpClient();

        // Create POST request
        HttpPost request = new HttpPost(SECRET_API_URL + SECRET_API_KEY);

        // Set content type to JSON
        request.addHeader("Content-Type", "application/json");

        // Convert post data to JSON
        byte[] json = mapper.writeValueAsBytes(req);

        // Send post data as byte array
        request.setEntity(new ByteArrayEntity(json));

        // Execute the request
        HttpResponse response = client.execute(request, new BasicHttpContext());

        // Get response JSON as string
        String responseJSON = EntityUtils.toString(response.getEntity());

        // Convert JSON response into HashMap
        Map<String, Object> map = mapper.readValue(responseJSON, Map.class);

        // Got an error?
        if (map.containsKey("error")) {
            // Throw it
            throw new Exception(map.get("error").toString());
        }
    }
}
