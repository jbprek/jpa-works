package jpa.relationship.listorder;

import jpa.relationship.listorder.PrintJob;
import jpa.relationship.listorder.PrintQueue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by x on 5/16/15.
 */


public class TestPrintQueueJobs {
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

    private PrintQueue createPrintQueue(String name) {
        PrintQueue d = new PrintQueue();
        d.setName(name);
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();

        return d;
    }




    private PrintJob submitJob(PrintQueue q, String payload, long order) {
        PrintJob job = new PrintJob();
        job.setQueue(q);
        job.setPayload(payload);
//        job.setPrintOrder(order_by);
        job.getQueue().getJobs().add(job);
        em.getTransaction().begin();
        em.persist(job);
        em.getTransaction().commit();
        return job;
    }

//
//    private PrintJob processJob(PrintQueue q) {
//        PrintJob first = q.getJobs().get(0);
//        q.getJobs().remove(0);
//        em.getTransaction().begin();
//        em.remove(first);
//        em.merge(q);
//        em.getTransaction().commit();
//        return first;
//    }
//
//
    @Test
    public void test() {
        PrintQueue hell = createPrintQueue("hell");
        PrintJob job3 = submitJob(hell, "Job 3 ",3);
        PrintJob job1 = submitJob(hell, "Job 1 ", 1);
        PrintJob job2 = submitJob(hell, "Job 2 ", 2);

//        System.out.println(hell.getJobs());
//
//        PrintJob printed1 = processJob(hell);
//        Assert.assertEquals(job1.getPrintOrder(), printed1.getPrintOrder());
//        Assert.assertEquals(job1.getPayload(), printed1.getPayload());
//
//        PrintJob printed2 = processJob(hell);
//        Assert.assertEquals(job2.getPrintOrder(), printed2.getPrintOrder());
//        Assert.assertEquals(job2.getPayload(), printed2.getPayload());
//
//        PrintJob printed3 = processJob(hell);
//        Assert.assertEquals(job3.getPrintOrder(), printed3.getPrintOrder());
//        Assert.assertEquals(job3.getPayload(), printed3.getPayload());


    }


}
