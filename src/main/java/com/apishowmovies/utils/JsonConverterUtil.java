package com.apishowmovies.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverterUtil {
    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
        return objectMapper;
    }

    public static <R> R jsonToObject(File jsonFile, Class<R> clazz) {
        R result = null;
        try {
            result = getObjectMapper().readValue(jsonFile, clazz);
        } catch (IOException e) {
            System.out.println("JsonConverterUtil: erro ao converter arquivo JSON para OBJECT" + e.getMessage());
        }
        return result;
    }

    public static <R> R jsonToObject(String json, Class<R> clazz) {
        R result = null;
        try {
            result = getObjectMapper().readValue(json, clazz);
        } catch (IOException e) {
            System.out.println("JsonConverterUtil: erro ao converter de JSON para OBJECT" + e.getMessage());
        }
        return result;
    }

    public static String objectToJson(Object object) {
        String result = null;
        try {
            result = getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println("JsonConverterUtil: erro ao converter de OBJECT para JSON" + e.getMessage());
        }
        return result;
    }
}
