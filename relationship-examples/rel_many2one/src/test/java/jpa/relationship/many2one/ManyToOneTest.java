package jpa.relationship.many2one;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;


public class ManyToOneTest {
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


    private EntityTransaction beginTx() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }

    private Employee createEmployee(String name) {
        EntityTransaction tx = beginTx();
        Employee e = new Employee();
        e.setName(name);
        em.persist(e);
        tx.commit();
        return e;
    }

    private Employee findEmployee(long id) {
        return em.find(Employee.class, id);
    }

    private Department createDepartment(String name) {
        EntityTransaction tx = beginTx();
        Department e = new Department();
        e.setName(name);
        em.persist(e);
        tx.commit();
        return e;
    }

    private Department findDepartment(long id) {
        return em.find(Department.class, id);
    }

    public void departmentAssign(long employeeId, long departmentId) {
        EntityTransaction tx = beginTx();
        Employee e = findEmployee(employeeId);
        Department d  = findDepartment(departmentId);
        Objects.nonNull(d);
        e.setDepartment(d);
        tx.commit();
    }

    @Test
    public void test() {
        // Create Employee
        Employee john = createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", findEmployee(john.getId()).getName());

        // Create another Employee
        Employee george = createEmployee("George");
        // Lookup Employee by id
        Assert.assertEquals("George", findEmployee(george.getId()).getName());

        // Create Department
        Department hell = createDepartment("Hell");
        // Lookup Department by id
        Assert.assertEquals("Hell", findDepartment(hell.getId()).getName());

        // Create Another Department
        Department inferno = createDepartment("Inferno");
        // Lookup Department by id
        Assert.assertEquals("Inferno", findDepartment(inferno.getId()).getName());

        // Associate john with Hell
        departmentAssign(john.getId(), hell.getId());
        // Verify Association
        Assert.assertEquals("Hell", findEmployee(john.getId()).getDepartment().getName());

        // Associate george with Hell
        departmentAssign(george.getId(), hell.getId());
        // Verify Association

        Assert.assertEquals("Hell", findEmployee(george.getId()).getDepartment().getName());

        // Promote george to Inferno
        departmentAssign(george.getId(), inferno.getId());
        // Verify Association
        Assert.assertEquals("Inferno", findEmployee(george.getId()).getDepartment().getName());



    }
}
