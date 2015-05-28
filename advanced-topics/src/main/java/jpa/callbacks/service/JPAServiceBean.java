package jpa.callbacks.service;



import jpa.callbacks.model.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class JPAServiceBean {
    public static Logger log = Logger.getLogger(JPAServiceBean.class.getName());

    @PersistenceContext(name = "test-advanced")
    private EntityManager em;


    public Employee createEmployee(String name) {
        log.info("Create Employee");
        Employee emp = new Employee();
        emp.setName(name);
        em.persist(emp);
        return emp;
    }

    public Employee findEmployee(long id) {
        log.info("Find Employee");
        return em.find(Employee.class, id);
    }

    public void delete(Employee e) {
        Employee d = em.merge(e);
        em.remove(d);
    }

    public Employee update(long id, String newName) {
        Employee e = em.find(Employee.class, id);
        if (e != null)
            e.setName(newName);

        return e;
    }





}
