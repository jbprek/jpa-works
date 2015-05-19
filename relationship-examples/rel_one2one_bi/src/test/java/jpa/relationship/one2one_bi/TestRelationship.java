package jpa.relationship.one2one_bi;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Created by x on 5/1/15.
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


    private EntityTransaction  beginTx() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }


    public Employee createEmployee(String name) {
        EntityTransaction tx  = beginTx();
        Employee emp = new Employee();
        emp.setName(name);
        em.persist(emp);
        tx.commit();
        return emp;
    }

    public Employee findEmployee(long id) {
        return em.find(Employee.class, id);
    }

    public ParkingLot createParkingLot(String code) {
        EntityTransaction tx  = beginTx();
        ParkingLot lot = new ParkingLot();
        lot.setCode(code);
        em.persist(lot);
        tx.commit();
        return lot;
    }

    public ParkingLot findLot(long id) {
        return em.find(ParkingLot.class, id);
    }

    public void parkingAssign(long employeeId, long parkingId) {
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        ParkingLot l  = findLot(parkingId);
        if ( l.getEmployee() != null)
            l.getEmployee().setParkingLot(null);
        e.setParkingLot(l);
        l.setEmployee(e);
        tx.commit();
    }

    public void freeParkingLot(long employeeId){
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        ParkingLot l = e.getParkingLot();
        e.setParkingLot(null);
        l.setEmployee(null);
        tx.commit();
    }

    @Test
    public void test() {
        // Create Employee
        Employee e1 = createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", findEmployee(e1.getId()).getName());

        // Create ParkingLot
        ParkingLot l1 = createParkingLot("P1");
        // Lookup ParkingLot by id
        Assert.assertEquals("P1", findLot(l1.getId()).getCode());

        // Associate Parking with Employee
        parkingAssign(e1.getId(), l1.getId());
        // Verify Association
        Assert.assertEquals("P1", findEmployee(e1.getId()).getParkingLot().getCode());

        // Disasociatate Parking with Employee
        freeParkingLot(e1.getId());
        // Verify Association
        Assert.assertNull( findEmployee(e1.getId()).getParkingLot());
        Assert.assertNull( findLot(l1.getId()).getEmployee());


        /** See what happens when we try to assign another employee to a used parking */
        parkingAssign(e1.getId(), l1.getId());
        Assert.assertEquals("P1", findEmployee(e1.getId()).getParkingLot().getCode());

        Employee e2 = createEmployee("George");
        Assert.assertEquals("George", findEmployee(e2.getId()).getName());

       parkingAssign(e2.getId(), l1.getId());

        Assert.assertNull( findEmployee(e1.getId()).getParkingLot());
        Assert.assertEquals("George", findLot(l1.getId()).getEmployee().getName());
        Assert.assertEquals("P1", findEmployee(e2.getId()).getParkingLot().getCode());
        /* Everything went smoothly since parkingAssign() has the provision to unassign the previous employee*/
    }
}
