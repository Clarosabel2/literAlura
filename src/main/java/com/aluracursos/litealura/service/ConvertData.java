package com.aluracursos.litealura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertData implements  IConvertData{
    private ObjectMapper objMapper = new ObjectMapper();
    @Override
    public <T> List<T> getData(String json, Class<T> clazz) {
        try {
            JsonNode rootNode = objMapper.readTree(json);
            JsonNode resultsNode =rootNode.get("results");
            if (resultsNode != null && resultsNode.isArray()) {
                return objMapper.readValue(resultsNode.toString(),
                        objMapper.getTypeFactory().constructCollectionType(List.class, clazz));
            } else {
                throw new RuntimeException("No se encontró el nodo 'results' o no es un array.");
            }
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
