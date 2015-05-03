package org.bagab.entity.relationships.test.scratch;

import org.bagab.entity.relationships.one2many_bi.Department;
import org.bagab.entity.relationships.one2many_bi.Employee;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.out;

/**
 * Created by x on 5/1/15.
 */
public class OneToManyBiTest {

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
        // Populate
        em.getTransaction().begin();

        Department d = new Department();
        d.setName("HELL");
        em.persist(d);

        em.getTransaction().commit();

        em.getTransaction().begin();

        d = em.find(Department.class, d.getId());
        out.println(d.getName() + " Persisted");
        out.println(d.getEmployees() + " col");
        em.getTransaction().commit();


//        Employee e1 = new Employee();
//        e1.setName("John");
//        e1.setDepartment(d);
//        d.getEmployees().add(e1);
//        em.persist(e1);
////
////        Employee e2 = new Employee();
////        e2.setName("George");
////        e2.setDepartment(d);
////        d.getEmployees().add(e2);
////        em.persist(e2);
//
////        em.persist(d);
//
//
//        em.persist(d);
//        em.getTransaction().commit();
//        // Read
//        em.getTransaction().begin();
//
//        Department dl = em.find(Department.class, d.getId());
//        Set<Employee> found = new HashSet<>();
//        found.addAll(dl.getEmployees());
//        Assert.assertTrue(found.contains(e1));
////        Assert.assertTrue(found.contains(e2));
//
//        em.getTransaction().commit();
    }


}
