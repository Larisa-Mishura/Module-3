package com.mishura.repository;

import com.mishura.model.Teacher;

public class TeacherRepository implements SearchableRepository, GeneralRepository<Teacher> {

    private static TeacherRepository instance;

    public TeacherRepository() {
    }

    public static TeacherRepository getInstance() {
        if (instance == null) {
            instance = new TeacherRepository();
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        getSql("SELECT * FROM teacher WHERE " + field + " LIKE '" + fieldName + "'");
    }

}