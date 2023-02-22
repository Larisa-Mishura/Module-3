package com.mishura.service;

import com.mishura.repository.*;

public class UniversityService {

    private static UniversityService instance;

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;


    public UniversityService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public static UniversityService getInstance() {
        if (instance == null) {
            instance = new UniversityService(StudentRepository.getInstance(), SubjectRepository.getInstance());
        }
        return instance;
    }

    public void getAverageGradeInGroup() {
        studentRepository.getAverageGradeInGroup();
    }

    public void getByFieldName(String field, String fieldName, SearchableRepository searchableRepository) {
        searchableRepository.getByFieldName(field, fieldName);
    }

    public void getGroupSizes() {
        studentRepository.getGroupSizes();
    }

    public void getStudentsByGrade(double grade) {
        studentRepository.getStudentsByGrade(grade);
    }

    public void getBestGradesSubject() {
        subjectRepository.getBestGradesSubject();
    }

    public void getWorstGradesSubject() {
        subjectRepository.getWorstGradesSubject();
    }
}
