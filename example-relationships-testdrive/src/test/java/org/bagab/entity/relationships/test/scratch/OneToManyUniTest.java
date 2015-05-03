package org.bagab.entity.relationships.test.scratch;

import org.bagab.entity.relationships.one2one_uni.Employee;
import org.bagab.entity.relationships.one2one_uni.ParkingLot;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by x on 5/1/15.
 */
public class OneToManyUniTest {

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
        Employee e = new Employee();
        e.setName("John");
        ParkingLot p = new ParkingLot();
        p.setName("CD1");
        e.setParkingLot(p);
        // Read aloud first persist the non-owner side
        em.persist(p);
        em.persist(e);
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
