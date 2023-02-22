package com.mishura.repository;

import com.mishura.model.Group;

public class GroupRepository implements SearchableRepository, GeneralRepository<Group>{

    private static GroupRepository instance;

    public GroupRepository() {
    }

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    //getSql("SELECT * FROM student_group WHERE " + field + " LIKE '%" + fieldName + "%'");

    public void getByFieldName(String field, String fieldName) {
        getSql("SELECT * FROM student_group WHERE " + field + " LIKE '" + fieldName + "'");
    }

}
