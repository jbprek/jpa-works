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

    public Phone createPhone(String code) {
        EntityTransaction tx  = beginTx();
        Phone phone = new Phone();
        phone.setCode(code);
        em.persist(phone);
        tx.commit();
        return phone;
    }

    public Phone findPhone(long id) {
        return em.find(Phone.class, id);
    }

    public void deliverPhoneToEmployee(long employeeId, long phoneId) {
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        Phone l  = findPhone(phoneId);
        e.getPhones().add(l);
        tx.commit();
    }

    public void removePhoneFromEmployee(long employeeId, long phoneId){
        EntityTransaction tx  = beginTx();
        Employee e = findEmployee(employeeId);
        Phone phone = findPhone(phoneId);
        e.getPhones().remove(phone) ;
        tx.commit();
    }

    @Test
    public void test() {
        // Create Employee
        Employee john = createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", findEmployee(john.getId()).getName());
        // Create Phone
        Phone p1 = createPhone("P1");
        // Lookup Phone by id
        Assert.assertEquals("P1", findPhone(p1.getId()).getCode());
        // Associate Phone with Employee
        deliverPhoneToEmployee(john.getId(), p1.getId());
        // Verify Association
        Assert.assertTrue(findEmployee(john.getId()).getPhones().contains(p1));
        // Dis-asociatate Parking with Employee
        removePhoneFromEmployee(john.getId(), p1.getId());

        findEmployee(john.getId()).getPhones();
        // Verify Association

        Assert.assertFalse(findEmployee(john.getId()).getPhones().contains(p1));
    }

}
