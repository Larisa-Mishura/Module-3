package com.mishura.service;

import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.SearchableRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.TeacherRepository;
import lombok.Getter;

import java.util.Random;

@Getter
public class TeacherService implements SearchService{

    private final GeneralRepository<Teacher> repository;

    private static final Random RANDOM = new Random();

    private static TeacherService instance;

    public TeacherService(GeneralRepository<Teacher> repository) {
        this.repository = repository;
    }

    public static TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService(TeacherRepository.getInstance());
        }
        return instance;
    }

    public static TeacherService getInstance(GeneralRepository<Teacher> repository) {
        if (instance == null) {
            instance = new TeacherService(repository);
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        SearchableRepository searchableRepository = (SearchableRepository) getInstance().repository;
        searchableRepository.getByFieldName(field, fieldName);
    }
}
