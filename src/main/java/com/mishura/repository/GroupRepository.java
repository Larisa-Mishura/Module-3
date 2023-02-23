package com.mishura.repository;

import com.mishura.model.Group;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GroupRepository implements SearchableRepository{

    private static GroupRepository instance;

    public GroupRepository() {
    }

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    public void getByFieldName(String field, String fieldName) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM student_group WHERE " + field + " LIKE '%" + fieldName + "%'");
        query.getResultList().forEach(System.out::println);
    }

}
