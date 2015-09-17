package com.bagab.entity.se;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

/**
 * Created by u on 4/13/15.e
 */
public class ExampleDAO {

    private EntityManager em;

    public ExampleDAO(EntityManager em){
        Objects.requireNonNull(em);
        this.em = em;
    }

    public Example create(String name, int salary) {
        Objects.requireNonNull(name);
        try {
            Objects.requireNonNull(name);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Example e = new Example();
            e.setName(name);
            e.setSalary(salary);
            em.persist(e);
            tx.commit();
            return e;
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public Example find(int id) {
        return em.find(Example.class, id);
    }

    public List<Example> findAll() {
        TypedQuery<Example> query = em.createQuery("select e from Example e", Example.class);
        return query.getResultList();
    }

    public Example remove(int id){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Example e = find(id);
        if ( e != null)
            em.remove(e);
        tx.commit();
        return e;
    }

    public void raiseEmployeeSalary(int id, int newSalary){
        Example e = find(id);
        if ( e != null){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            e.setSalary(newSalary);
            tx.commit();
        }
    }

}
