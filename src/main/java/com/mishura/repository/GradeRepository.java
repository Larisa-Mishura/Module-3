package com.mishura.repository;

public class GradeRepository{

    private static GradeRepository instance;

    public GradeRepository() {
    }

    public static GradeRepository getInstance() {
        if (instance == null) {
            instance = new GradeRepository();
        }
        return instance;
    }
}
