package com.mishura.repository;

import com.mishura.model.Grade;

public class GradeRepository implements GeneralRepository<Grade> {

    private static GradeRepository instance;

    public GradeRepository() {
    }

    public static GradeRepository getInstance() {
        if (instance == null) {
            instance = new GradeRepository();
        }
        return instance;
    }

    public void getAverageGradeInGroup(){
        getSql("SELECT group_id, AVG(mark) " +
                "FROM " + STUDENTS_GROUPS_GRADES_SUBJECTS +
                "GROUP BY group_id") ;
    }
}
