package com.mishura.repository;

public class TeacherRepository implements SearchableRepository, GeneralRepository{

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