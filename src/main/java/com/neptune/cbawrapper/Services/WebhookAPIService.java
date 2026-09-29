package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.CreateBizRequest;
import com.neptune.cbawrapper.Models.CreateBizResponse;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebhookAPIService {

    private final RestTemplate restTemplate;
    @Value("${grpc.account.ebiz.request.url}")
    private String ebiz_server_url;

    public CreateBizResponse.BizResponseData pushEbizUpdate(VirtualAccountModel accountModel){
        try {
            CreateBizRequest request = CreateBizRequest.builder().id(accountModel.getBusiness_id()).parent_account_number(accountModel.getParent_account()).pos_account_number(accountModel.getVirtual_account_number()).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CreateBizRequest> requestEntity =
                    new HttpEntity<>(request, headers);

            ResponseEntity<CreateBizResponse> response =
                    restTemplate.postForEntity(
                            ebiz_server_url,
                            requestEntity,
                            CreateBizResponse.class
                    );

            System.out.println("response.getBody() = " + response.getBody());

            return response.getBody().getData();
        } catch (RestClientException e) {

            log.error("Failed to fetch CRC report for BVN {}", e);

            return null;
        }
    }
}
