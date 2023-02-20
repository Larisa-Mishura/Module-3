package com.mishura.repository;

import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.model.Teacher;
import com.mishura.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface GeneralRepository<T> {

    default void save( @Valid final T object) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    default void getSql(String sql, Class<T> classT) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        for(Iterator it = list.iterator(); it.hasNext(); ) {
            Object[] obj = (Object[]) it.next();
            System.out.println(Arrays.toString(obj));
        }
    }

    default List getSql(String sql) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        for(Iterator it = list.iterator(); it.hasNext(); ) {
            Object[] obj = (Object[]) it.next();
            System.out.println(Arrays.toString(obj));
        }
        return list;
    }
}
