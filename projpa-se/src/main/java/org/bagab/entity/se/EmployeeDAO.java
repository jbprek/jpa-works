package org.bagab.entity.se;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

/**
 * Created by u on 4/13/15.e
 */
public class EmployeeDAO {

    private EntityManager em;

    public EmployeeDAO(EntityManager em){
        Objects.requireNonNull(em);
        this.em = em;
    }

    public Employee create(String name, int salary) {
        Objects.requireNonNull(name);
        try {
            Objects.requireNonNull(name);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Employee e = new Employee();
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

    public Employee find(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
        return query.getResultList();
    }

    public Employee remove(int id){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee e = find(id);
        if ( e != null)
            em.remove(e);
        tx.commit();
        return e;
    }

    public void raiseEmployeeSalary(int id, int newSalary){
        Employee e = find(id);
        if ( e != null){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            e.setSalary(newSalary);
            tx.commit();
        }
    }

}
