package com.mishura.service;

import com.mishura.repository.GradeRepository;
import com.mishura.repository.SearchableRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.SubjectRepository;

public class UniversityService {
    public void getAverageGradeInGroup() {
        GradeRepository.getInstance().getAverageGradeInGroup();
    }

    public void getByFieldName(String field, String fieldName, SearchableRepository searchableRepository) {
        searchableRepository.getByFieldName(field, fieldName);
    }

    public void getGroupSizes() {
        StudentRepository.getInstance().getGroupSizes();
    }

    public void getStudentsByGrade(double grade) {
        StudentRepository.getInstance().getStudentsByGrade(grade);
    }

    public void getBestGradesSubject() {
        SubjectRepository.getInstance().getBestGradesSubject();
    }

    public void getWorstGradesSubject() {
        SubjectRepository.getInstance().getWorstGradesSubject();
    }
}
