package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转JSON字符串
     *
     * @param data
     * @return
     */
    public static String ObjectToJson(Object data) {
        try {
            String string = objectMapper.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JSON字符串转对象
     * @param string
     * @param <T>
     * @return
     */
    public static <T>Object JsonToObject(String string,Class<T> baseType){
        try {
            T t = objectMapper.readValue(string, baseType);
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
