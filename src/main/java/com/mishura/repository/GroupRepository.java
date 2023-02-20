package com.mishura.repository;

import com.mishura.model.Group;
import com.mishura.model.Teacher;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GroupRepository implements SearchableRepository, GeneralRepository<Group>{

    private static String QUERY_SELECT = "SELECT * FROM student_group";

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
        getSql("SELECT * FROM student_group WHERE " + field + " LIKE '%" + fieldName + "%'", Group.class);

    }



}
