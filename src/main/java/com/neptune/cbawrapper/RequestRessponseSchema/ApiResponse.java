package com.neptune.cbawrapper.RequestRessponseSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T extends Serializable> implements Serializable {

    private int status;
    private String message;
    private T dataSchema;
    private String uri;
    private ZonedDateTime timeStamp;
    private boolean enc;

    public static ApiResponse parameterError(final String uri, final String message, final Object... defaultUserMessageArgs) {
        return new ApiResponse(HttpStatus.FORBIDDEN.value(), message, defaultUserMessageArgs, uri, null, false);
    }
}