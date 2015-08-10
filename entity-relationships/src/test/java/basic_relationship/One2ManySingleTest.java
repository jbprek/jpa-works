package basic_relationship;

import basic_relationship.one2many_si.Presentation;
import basic_relationship.one2many_si.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by john on 8/9/15.
 */
public class One2ManySingleTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("entity-relationships");
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

    @Test
    public void test() {
        EntityTransaction tx = beginTx();
        Student john = new Student();
        john.setName("John");
        em.persist(john);

        Presentation hist = new Presentation();
        hist.setTitle("History");
        em.persist(hist);

        Presentation bio = new Presentation();
        hist.setTitle("Biology");
        em.persist(bio);

        john.getPresentations().add(hist);
        john.getPresentations().add(bio);
        em.flush();

        tx.commit();

        tx = beginTx();

        Student s = em.find(Student.class, john.getId());
        Assert.assertEquals(2, s.getPresentations().size());

        tx.commit();

    }


}

