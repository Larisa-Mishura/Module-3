package com.mishura.service;

import com.mishura.model.Grade;
import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.GradeRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.TeacherRepository;

import java.util.Random;

public class GradeService {

    private final GeneralRepository<Grade> repository;

    private static GradeService instance;

    public GradeService(GeneralRepository<Grade> repository) {
        this.repository = repository;
    }

    public static GradeService getInstance() {
        if (instance == null) {
            instance = new GradeService(GradeRepository.getInstance());
        }
        return instance;
    }

    public static GradeService getInstance(GeneralRepository<Grade> repository) {
        if (instance == null) {
            instance = new GradeService(repository);
        }
        return instance;
    }

    public void getAverageGradeInGroup() {
        GradeRepository.getInstance().getAverageGradeInGroup();
    }
}
