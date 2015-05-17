package jpa.compoundpk.idclass;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by x on 5/5/15.
 */
public class TestRelationship {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-relationships");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if (em != null)
            em.close();
        entityManagerFactory.close();
    }
//
    private Employee createEmployee(long code, String country, String name) {
        Employee e = new Employee();
        e.setCode(code);
        e.setCounty(country);
        e.setName(name);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();

        return e;
    }

    private Employee findEmployee(long code, String country) {
        EmployeeId id = new EmployeeId(code, country);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee copy = em.find(Employee.class, id);
        tx.commit();

        return copy;
    }

    @Test
    public void test() {
//        // Create employees John and George
        Employee john = createEmployee(0, "Greece", "John");
        Assert.assertEquals(john, findEmployee(0, "Greece"));
    }

}
