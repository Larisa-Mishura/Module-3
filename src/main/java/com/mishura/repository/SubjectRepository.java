package com.mishura.repository;

import com.mishura.model.Subject;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class SubjectRepository implements GeneralRepository<Subject> {

    private static SubjectRepository instance;

    public SubjectRepository() {
    }

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }


    public void getBestGradesSubject(){

        getSql("SELECT subject_name, AVG(mark) AS average_grade " +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY subject_name");
    }

    public void getWorstGradesSubject(){
        getSql("SELECT subject_name, AVG(mark) AS average_grade " +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY subject_name");
    }


}
