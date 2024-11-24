package com.neptune.cbawrapper.RequestRessponseSchema;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.ArrayList;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoreExceptionResponse implements Serializable {

    @JsonProperty
    private String developerMessage;
    @JsonProperty
    private String httpStatusCode;
    @JsonProperty
    private String defaultUserMessage;
    @JsonProperty
    private String userMessageGlobalisationCode;
    @JsonProperty
    private ArrayList<Errors> errors = new ArrayList<>();

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDefaultUserMessage() {
        return defaultUserMessage;
    }

    public void setDefaultUserMessage(String defaultUserMessage) {
        this.defaultUserMessage = defaultUserMessage;
    }

    public String getUserMessageGlobalisationCode() {
        return userMessageGlobalisationCode;
    }

    public void setUserMessageGlobalisationCode(String userMessageGlobalisationCode) {
        this.userMessageGlobalisationCode = userMessageGlobalisationCode;
    }

    public ArrayList<Errors> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Errors> errors) {
        this.errors = errors;
    }
}
