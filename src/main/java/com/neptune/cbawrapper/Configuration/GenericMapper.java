package com.neptune.cbawrapper.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenericMapper implements Serializable {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS);
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T convertJsonBodyToObject(String jsonBody, Class<T> clazz) throws RuntimeException {
        if (org.apache.commons.lang3.StringUtils.isBlank(jsonBody)) {
            throw new RuntimeException("Received empty response body");
        }
        try {
            return OBJECT_MAPPER.readValue(jsonBody, clazz);
        } catch (IOException e) {
            log.error("Error while de-serializing json body: {}", e);
            throw new RuntimeException("Could not read response body", e);
        }
    }

    public static <T> T convertJsonBodyToObject(InputStream inputStream, Class<T> clazz) throws RuntimeException {
        if (inputStream == null) {
            throw new RuntimeException("Received empty inputStream body");
        }
        try {
            return OBJECT_MAPPER.readValue(inputStream, clazz);
        } catch (IOException e) {
            log.error("Error while de-serializing inputStream body: {}", e);
            throw new RuntimeException("Could not read inputStream body", e);
        }
    }

    public static <T> T converObjectToOther(Object object, Class<T> clazz) throws RuntimeException {
        if (object == null) {
            throw new RuntimeException("Received empty object body");
        }
        try {
            return OBJECT_MAPPER.convertValue(object, clazz);
        } catch (IllegalArgumentException e) {
            log.error("Error while de-serializing object body: {}", e);
            throw new RuntimeException("Could not read object body", e);
        }
    }

    public static <T> List<T> convertJsonArrayToList(String jsonArray, Class<T> clazz) throws RuntimeException {

        if (StringUtils.isBlank(jsonArray)) {
            throw new RuntimeException("Received empty response body");
        }

        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
            return OBJECT_MAPPER.readValue(jsonArray, javaType);
        } catch (IOException e) {
            log.error("Error while de-serializing json body: {}", e);
            throw new RuntimeException("Could not read response body", e);
        }

    }

    public static String objToJsonStringMapper(final Object obj) {
        try {
            return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).findAndRegisterModules().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Error while de-serializing to String: {}", e);
            throw new RuntimeException(e);
        }
    }
}
