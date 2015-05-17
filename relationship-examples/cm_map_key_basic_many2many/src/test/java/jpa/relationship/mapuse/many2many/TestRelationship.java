package jpa.relationship.mapuse.many2many;


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

    private Employee createEmployee(String name) {
        Employee e = new Employee();
        e.setName(name);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();

        return e;
    }

    private Employee findEmployee(long id) {
        return em.find(Employee.class, id);
    }

    private Project createProject(String name) {
        Project e = new Project();
        e.setName(name);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();

        return e;
    }

    private Project findProject(long id) {
        return em.find(Project.class, id);
    }
//
//    private void assignToProject(Employee e, Project p, String assignement) {
//
//        p.getEmployees().add(e);
//        e.getProjectsByAssignement().put(assignement, p);
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.merge(e);
//        em.merge(p);
//
//        tx.commit();
//    }
//
//    private void dismissFromProject(Employee e, Project p) {
//
//        e.getProjects().remove(p);
//        p.getEmployees().remove(e);
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.merge(e);
//        em.merge(p);
//
//        tx.commit();
//    }


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

//        // Assign John to Hell
//        assignToProject(john, hell);
//        Assert.assertEquals(1, findEmployee(john.getId()).getProjects().size());
//        Assert.assertEquals(1, findProject(hell.getId()).getEmployees().size());
//         Assert.assertTrue(findEmployee(john.getId()).getProjects().contains(hell));
//        Assert.assertTrue(findProject(hell.getId()).getEmployees().contains(john));
//
//        // Assign George to Inferno
//        assignToProject(george, inferno);
//        Assert.assertEquals(1, findEmployee(george.getId()).getProjects().size());
//        Assert.assertEquals(1, findProject(inferno.getId()).getEmployees().size());
//        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(inferno));
//        Assert.assertTrue(findProject(inferno.getId()).getEmployees().contains(george));
//
//        // Remove John from Hell
//        dismissFromProject(john, hell);
//        Assert.assertEquals(0, findEmployee(john.getId()).getProjects().size());
//        Assert.assertEquals(0, findProject(hell.getId()).getEmployees().size());
//        Assert.assertFalse(findEmployee(john.getId()).getProjects().contains(hell));
//
//        // Assign George to Hell
//        assignToProject(george, hell);
//        Assert.assertEquals(2, findEmployee(george.getId()).getProjects().size());
//        Assert.assertEquals(1, findProject(hell.getId()).getEmployees().size());
//        Assert.assertEquals(1, findProject(inferno.getId()).getEmployees().size());
//        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(inferno));
//        Assert.assertTrue(findEmployee(george.getId()).getProjects().contains(hell));
    }

}
