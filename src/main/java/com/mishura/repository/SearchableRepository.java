package com.mishura.repository;
import lombok.SneakyThrows;

public interface SearchableRepository {

    @SneakyThrows
    void getByFieldName(String field, String fieldName);
}
