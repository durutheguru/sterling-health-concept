package io.duru.projects.sterling.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * created by dduru on 06/10/2018
 */
public class JSONUtil {

    private final static ObjectMapper objectMapper;


    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }


    public static <T> String stringify(T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }


}