package jpa.relationship.one2many_uni;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by x on 5/1/15.
 */
public class TestRelationship {


    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("basic_relationship.one2one_bi");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if (em != null)
            em.close();
        entityManagerFactory.close();
    }

    private EntityTransaction  beginTx() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }



    @Test
    public void test() {
        // Create a transaction
        EntityTransaction tx = null;

        // Create Employee
        tx = beginTx();
        Employee e1 = new Employee("John");
        em.persist(e1);

        // Create ParkingLot
        ParkingLot l1 = new ParkingLot("P1");
        em.persist(l1);

        // Associate Parking with Employee
        e1.setParkingLot(l1);
        e1 = em.merge(e1);

        tx.commit();

        tx = beginTx();

        // Lookup Employee by id
        Assert.assertEquals("John", em.find(Employee.class, e1.getId()).getName());

        // Lookup ParkingLot by id
        Assert.assertEquals("P1", em.find(ParkingLot.class, l1.getId()).getCode());


        // Verify Association
        Employee test = em.find(Employee.class, e1.getId());

        Assert.assertEquals("P1", test.getParkingLot().getCode());
        tx.commit();

        // Disasociatate Parking with Employee
        tx = beginTx();
        test = em.find(Employee.class, e1.getId());
        test.setParkingLot(null);
        em.merge(test);
        tx.commit();

        tx = beginTx();
        test = em.find(Employee.class, e1.getId());
        Assert.assertEquals(null, test.getParkingLot());
        tx.commit();
//        freeParkingLot(e1.getId());
//
//        /** See what happens when we try to assign another employee to a used parking */
//        parkingAssign(e1.getId(), l1.getId());
//        Assert.assertEquals("P1", findEmployee(e1.getId()).getParkingLot().getCode());
//
//        Employee e2 = createEmployee("George");
//        Assert.assertEquals("George", findEmployee(e2.getId()).getName());
//
//        parkingAssign(e2.getId(), l1.getId());
//
//        Assert.assertNull(findEmployee(e1.getId()).getParkingLot());
//        Assert.assertEquals("P1", findEmployee(e2.getId()).getParkingLot().getCode());

    }
}