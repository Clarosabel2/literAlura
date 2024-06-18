package com.aluracursos.litealura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements  IConvertData{
    private ObjectMapper objMapper = new ObjectMapper();
    @Override
    public <T> T getData(String json, Class<T> clazz) {
        try {
            return objMapper.readValue(json,clazz);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}