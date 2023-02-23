package com.mishura.repository;

import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public interface GeneralRepository{

     String STUDENTS_GROUPS_GRADES_SUBJECTS = "( (student s LEFT JOIN student_grade g ON s.id = g.student_id) " +
            "LEFT JOIN grade m ON g.grade_id = m.gradeId)";

    default void getSql(String sql) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        for (Object o : list) {
            Object[] obj = (Object[]) o;
            System.out.println(Arrays.toString(obj));
        }
    }
}
