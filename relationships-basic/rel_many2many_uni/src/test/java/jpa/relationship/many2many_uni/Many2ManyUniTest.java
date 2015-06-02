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

    private Project createProject(String name) {
        EntityTransaction tx = beginTx();
        Project e = new Project();
        e.setName(name);
        em.persist(e);
        tx.commit();
        return e;
    }

    private Project findProject(long id) {
        return em.find(Project.class, id);
    }

    private void assignToProject(long employeeId, long ProjectId) {
        EntityTransaction tx = beginTx();
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Project p = findProject(ProjectId);
        Objects.nonNull(p);

        e.getProjects().add(p);
        tx.commit();
    }

    private void dismissFromProject(long employeeId, long ProjectId) {
        EntityTransaction tx = beginTx();
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Project p = findProject(ProjectId);
        Objects.nonNull(p);

        e.getProjects().remove(p);
        tx.commit();
    }

    private Set<Project> getEmployeesProjects(long employeeId){
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);
        return e.getProjects();
    }

    @Test
    public void test() {
        // Create employees John and George
        Employee john = createEmployee("John");
        Assert.assertEquals("John", findEmployee(john.getId()).getName());

        Employee george = createEmployee("George");
        Assert.assertEquals("George", findEmployee(george.getId()).getName());

        // Create projects Hell and Inferno
        Project hell = createProject("Hell");
        Assert.assertEquals("Hell", findProject(hell.getId()).getName());

        Project inferno = createProject("Inferno");
        Assert.assertEquals("Inferno", findProject(inferno.getId()).getName());

        // Assign John to Hell
        assignToProject(john.getId(), hell.getId());
        Assert.assertEquals(1, findEmployee(john.getId()).getProjects().size());
         Assert.assertTrue(findEmployee(john.getId()).getProjects().contains(hell));

        // Assign George to Inferno
        assignToProject(george.getId(), inferno.getId());
        Assert.assertEquals(1, findEmployee(george.getId()).getProjects().size());
        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(inferno));

        // Remove John from Hell
        dismissFromProject(john.getId(), hell.getId());
        Assert.assertEquals(0, findEmployee(john.getId()).getProjects().size());
        Assert.assertFalse(findEmployee(john.getId()).getProjects().contains(hell));

        // Assign George to Hell
        assignToProject(george.getId(), hell.getId());
        Assert.assertEquals(2, findEmployee(george.getId()).getProjects().size());

        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(inferno));
        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(hell));
    }

}
