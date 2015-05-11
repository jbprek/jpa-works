package org.bagab.entity.se;

import org.junit.*;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by u on 4/13/15.
 */
public class ExampleDAOTest {

    private static ExampleDAO dao;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void  setup(){
        emf = Persistence.createEntityManagerFactory("employee_pu");
        em = emf.createEntityManager();
        dao = new ExampleDAO(em);
    }

    @AfterClass
    public static void tearDown() {
        dao= null;
        em.close();
        emf.close();
    }

    @Test
    public void testCreateRemove() {
        Example e = dao.create("John", 1000);
        System.out.println(e);
        assertEquals("John", e.getName());
        assertEquals(1000, e.getSalary());
        Example r = dao.remove(e.getId());
    }

    @Test
    public void testCreateMultiple() {
        for (int i = 0; i < 10; i++)
            dao.create("name"+i, 100*i);

        List<Example> l = dao.findAll();
        for(Example e : l)
            System.out.println(e);

        assertEquals(10, l.size());
    }
}
