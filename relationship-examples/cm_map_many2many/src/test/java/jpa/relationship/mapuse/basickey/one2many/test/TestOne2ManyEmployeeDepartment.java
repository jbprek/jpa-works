package jpa.relationship.mapuse.basickey.one2many.test;


import jpa.relationship.mapuse.basickey.one2many.model.O2MDepartment;
import jpa.relationship.mapuse.basickey.one2many.model.O2MEmployee;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;

/**
 * Created by x on 5/16/15.
 */

public class TestOne2ManyEmployeeDepartment {
    private static EntityManagerFactory entityManagerFactory;
    private static  EntityManager em;

    @BeforeClass
    public static void setup(){
        entityManagerFactory = Persistence.createEntityManagerFactory("test-relationships");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if ( em != null)
            em.close();
        entityManagerFactory.close();
    }

    private O2MDepartment createDepartment(String name) {
        O2MDepartment d = new O2MDepartment();
        d.setName(name);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(d);
        tx.commit();

        return d;
    }


    private O2MEmployee  createEmployee(String name, long salary, O2MDepartment department, String cubicle) {
        O2MEmployee e = new O2MEmployee();
        e.setName(name);
        e.setSalary(salary);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();

        department.addEmployee(cubicle, e);

        return e;
    }



    @Test
    public void test() {

        O2MDepartment hell = new O2MDepartment();
        hell.setName("hell");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(hell);
       

        O2MEmployee john = new O2MEmployee();
        john.setName("john");
        john.setSalary(1000);
        hell.addEmployee("001", john);
        em.persist(john);

        O2MEmployee george = new O2MEmployee();
        george.setName("george");
        george.setSalary(1000);
        hell.addEmployee("002", george);
        em.persist(george);



        tx.commit();
        Map<String, O2MEmployee> employeesByCube = hell.getEmployees();
        for(String key : employeesByCube.keySet())
            System.out.println(key +":"+employeesByCube.get(key));


    }

}
