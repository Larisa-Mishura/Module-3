package com.mishura.service;

import com.mishura.repository.GeneralRepository;
import com.mishura.repository.SearchableRepository;

import java.time.Instant;

public interface SearchService{

    void getByFieldName(String field, String fieldName);
}
