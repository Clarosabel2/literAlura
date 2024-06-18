package com.aluracursos.litealura.service;

import java.util.List;

public interface IConvertData {
    <T> List<T> getData(String json, Class<T> clazz);
}
