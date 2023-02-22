package com.mishura.service;

import com.mishura.model.Subject;
import com.mishura.repository.GeneralRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.SubjectRepository;

public class SubjectService {

    private final GeneralRepository<Subject> repository;

    private static SubjectService instance;

    public SubjectService(GeneralRepository<Subject> repository) {
        this.repository = repository;
    }

    public static SubjectService getInstance() {
        if (instance == null) {
            instance = new SubjectService(SubjectRepository.getInstance());
        }
        return instance;
    }

    public static SubjectService getInstance(GeneralRepository<Subject> repository) {
        if (instance == null) {
            instance = new SubjectService(repository);
        }
        return instance;
    }

    public void getBestGradesSubject() {
        SubjectRepository.getInstance().getBestGradesSubject();
    }

    public void getWorstGradesSubject() {
        SubjectRepository.getInstance().getWorstGradesSubject();
    }


}
