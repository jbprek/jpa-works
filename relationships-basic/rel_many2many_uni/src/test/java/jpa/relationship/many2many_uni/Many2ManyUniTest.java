package jpa.relationship.many2many_uni;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;
import java.util.Set;

/**
 * Created by x on 5/5/15.
 */
public class Many2ManyUniTest {
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

    private Task createProject(String name) {
        EntityTransaction tx = beginTx();
        Task e = new Task();
        e.setName(name);
        em.persist(e);
        tx.commit();
        return e;
    }

    private Task findTask(long id) {
        return em.find(Task.class, id);
    }

    private void addTask(long employeeId, long taskId) {
        EntityTransaction tx = beginTx();
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Task p = findTask(taskId);
        Objects.nonNull(p);

        e.getTasks().add(p);
        tx.commit();
    }

    private void removeTask(long employeeId, long taskId) {
        EntityTransaction tx = beginTx();
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Task p = findTask(taskId);
        Objects.nonNull(p);

        e.getTasks().remove(p);
        tx.commit();
    }

    private Set<Task> getEmployeesProjects(long employeeId){
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);
        return e.getTasks();
    }

    @Test
    public void test() {
        // Create employees John and George
        Employee john = createEmployee("John");
        Assert.assertEquals("John", findEmployee(john.getId()).getName());

        Employee george = createEmployee("George");
        Assert.assertEquals("George", findEmployee(george.getId()).getName());

        // Create projects Hell and Inferno
        Task hell = createProject("Hell");
        Assert.assertEquals("Hell", findTask(hell.getId()).getName());

        Task inferno = createProject("Inferno");
        Assert.assertEquals("Inferno", findTask(inferno.getId()).getName());

        // Assign John to Hell
        addTask(john.getId(), hell.getId());
        Assert.assertEquals(1, findEmployee(john.getId()).getTasks().size());
         Assert.assertTrue(findEmployee(john.getId()).getTasks().contains(hell));

        // Assign George to Inferno
        addTask(george.getId(), inferno.getId());
        Assert.assertEquals(1, findEmployee(george.getId()).getTasks().size());
        Assert.assertTrue(findEmployee(george.getId()).getTasks().contains(inferno));

        // Remove John from Hell
        removeTask(john.getId(), hell.getId());
        Assert.assertEquals(0, findEmployee(john.getId()).getTasks().size());
        Assert.assertFalse(findEmployee(john.getId()).getTasks().contains(hell));

        // Assign George to Hell
        addTask(george.getId(), hell.getId());
        Assert.assertEquals(2, findEmployee(george.getId()).getTasks().size());

        Assert.assertTrue(findEmployee(george.getId()).getTasks().contains(inferno));
        Assert.assertTrue(findEmployee(george.getId()).getTasks().contains(hell));
    }

}
