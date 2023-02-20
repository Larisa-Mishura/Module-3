package com.mishura.repository;

import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.service.StudentService;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;

public class TeacherRepository implements SearchableRepository, GeneralRepository<Teacher> {

    private static String QUERY_SELECT = "SELECT * FROM teacher";

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
        getSql("SELECT * FROM teacher WHERE " + field + " LIKE '" + fieldName + "'", Teacher.class);
    }

}