package com.aluracursos.litealura.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> clazz);
}
