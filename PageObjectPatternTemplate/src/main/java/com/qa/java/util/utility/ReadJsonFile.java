package com.qa.java.utility;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ReadJsonFile {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

        public static ObjectMapper getDefaultObjectMapper() {
            ObjectMapper defaultObjectMapper = new ObjectMapper();
            defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return defaultObjectMapper;
        }

    public static JsonNode parse(String src) throws IOException {
            return objectMapper.readTree(src);
    }
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
            return objectMapper.treeToValue(node, clazz);
    }

}


