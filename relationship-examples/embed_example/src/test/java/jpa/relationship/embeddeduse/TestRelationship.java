package jpa.relationship.embeddeduse;


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
    private Employee createEmployee(String name , Address address) {
        Employee e = new Employee(name, address);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();
        return e;
    }

    private Employee findEmployee(long code) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee copy = em.find(Employee.class, code);
        tx.commit();

        return copy;
    }


    @Test
    public void test() {
//        // Create employees John and George
        Address address = new Address("1st Street", "1", "NY", "USA", "1234567");
        Employee john = createEmployee("john",address);
        Assert.assertEquals(john.getAddress(), findEmployee(john.getId()).getAddress());
    }

}
