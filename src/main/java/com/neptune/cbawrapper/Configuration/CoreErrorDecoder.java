package com.neptune.cbawrapper.Configuration;

import com.neptune.cbawrapper.Exception.AuthenticationException;
import com.neptune.cbawrapper.Exception.PlatformDomainRuleException;
import com.neptune.cbawrapper.RequestRessponseSchema.ApiResponse;
import com.neptune.cbawrapper.RequestRessponseSchema.CoreExceptionResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class CoreErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        final Integer status = response.status();
        System.out.println("response  = " + response );
        log.info("CoreErrorDecoder status: {}", status);

        CoreExceptionResponse exceptionMessage = null;

        if (response.body() != null) {
            try ( InputStream bodyIs = response.body()
                    .asInputStream()) {
                exceptionMessage
                        = GenericMapper.convertJsonBodyToObject(bodyIs, CoreExceptionResponse.class);
            } catch (IOException e) {
                return new Exception(e.getMessage());
            }
        }

        String errorCode = "error.fineract.code";
        String errorMessage = "Error connecting to server, try again.";
        if (exceptionMessage != null) {
            errorCode
                    = exceptionMessage.getUserMessageGlobalisationCode() != null
                    ? exceptionMessage.getUserMessageGlobalisationCode()
                    : "error.fineract";

            if (!exceptionMessage.getErrors().isEmpty()) {
                errorCode = exceptionMessage.getErrors().get(0).getAllErrors().get(0).getCode();
            }

            System.out.println("exceptionMessage.getDefaultUserMessage() = " + exceptionMessage.getDefaultUserMessage());


            errorMessage
                    = exceptionMessage.getDefaultUserMessage() != null
                    ? exceptionMessage.getDefaultUserMessage()
                    : "Server error occurred, Please contact the admin";
            if (!exceptionMessage.getErrors().isEmpty()) {
                errorMessage = exceptionMessage.getErrors().get(0).getAllErrors().get(0).getCode();
            }
            log.info("CoreExceptionResponse: {}", exceptionMessage.toString());
        }
        if (status == 401) {
            errorMessage = StringUtils.prependIfMissing(errorMessage, "401|");
        }
        final ApiResponse apiResponseMessage = new ApiResponse();
        apiResponseMessage.setDataSchema(exceptionMessage);
        apiResponseMessage.setMessage(errorMessage);
        apiResponseMessage.setStatus(response.status());
        switch (response.status()) {
            case 401:
                    throw new AuthenticationException(errorMessage, errorCode);
            case 400:
                    throw new PlatformDomainRuleException(errorCode, errorMessage);
            case 404:
                    throw new PlatformDomainRuleException(errorCode, errorMessage, apiResponseMessage);
            case 403:
                    throw new PlatformDomainRuleException(errorCode, errorMessage, apiResponseMessage);
            case 111:
                    throw new PlatformDomainRuleException(errorCode, errorMessage, apiResponseMessage);
            default:
                    throw new PlatformDomainRuleException(errorCode, errorMessage, apiResponseMessage);
        }
    }
}
