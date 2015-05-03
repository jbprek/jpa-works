package org.bagab.entity.relationships.test.scratch;

import org.bagab.entity.relationships.many2one.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by x on 5/1/15.
 */
public class ManyToOneTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void  setup(){
        emf = Persistence.createEntityManagerFactory("test-relationships");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void test() {
        em.getTransaction().begin();
        Department d = new Department();
        d.setName("KOLASI");
        em.persist(d);
        Employee e = new Employee();
        e.setName("John");
        e.setDepartment(d);
        em.persist(e);
        e = new Employee();
        e.setName("George");
        e.setDepartment(d);
        em.persist(e);
        // Read aloud first persist the non-owner side
        em.getTransaction().commit();

//        em.getTransaction().begin();
////        Employee e1 = em.find(Employee.class, e.getId());
//        ParkingLot p1 = em.find(ParkingLot.class, p.getId());
////        Assert.assertEquals("CD1",e1.getParkingLot().getCode());
//        Assert.assertEquals("John",p1.getEmployee().getName());
//
//        em.getTransaction().commit();
    }


}
