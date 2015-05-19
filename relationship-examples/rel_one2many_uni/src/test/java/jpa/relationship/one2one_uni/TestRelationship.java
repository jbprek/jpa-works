package jpa.relationship.one2one_uni;


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

    public Phone createParkingLot(String code) {
        EntityTransaction tx  = beginTx();
        Phone lot = new Phone();
        lot.setCode(code);
        em.persist(lot);
        tx.commit();
        return lot;
    }

    public Phone findPhone(long id) {
        return em.find(Phone.class, id);
    }

    public void deliverPhoneToEmployee(long employeeId, long parkingId) {
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        Phone l  = findPhone(parkingId);
        e.getPhones().add(l);
        tx.commit();
    }

    public void removePhoneFromEmployee(long employeeId, long phoneId){
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        Phone l = findPhone(phoneId)
        e.setPhones(null);
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
        Phone l1 = createParkingLot("P1");
        // Lookup ParkingLot by id
        Assert.assertEquals("P1", findPhone(l1.getId()).getCode());

        // Associate Parking with Employee
        deliverPhoneToEmployee(e1.getId(), l1.getId());
        // Verify Association
        Assert.assertEquals("P1", findEmployee(e1.getId()).getPhones().getCode());

        // Disasociatate Parking with Employee
        removePhoneFromEmployee(e1.getId());
        // Verify Association
        Assert.assertNull( findEmployee(e1.getId()).getPhones());
        Assert.assertNull( findPhone(l1.getId()).getEmployee());


        /** See what happens when we try to assign another employee to a used parking */
        deliverPhoneToEmployee(e1.getId(), l1.getId());
        Assert.assertEquals("P1", findEmployee(e1.getId()).getPhones().getCode());

        Employee e2 = createEmployee("George");
        Assert.assertEquals("George", findEmployee(e2.getId()).getName());

       deliverPhoneToEmployee(e2.getId(), l1.getId());

        Assert.assertNull( findEmployee(e1.getId()).getPhones());
        Assert.assertEquals("George", findPhone(l1.getId()).getEmployee().getName());
        Assert.assertEquals("P1", findEmployee(e2.getId()).getPhones().getCode());
        /* Everything went smoothly since deliverPhoneToEmployee() has the provision to unassign the previous employee*/
    }
}
