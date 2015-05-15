package org.bagab.entity.relationships.listorder.service;


import org.bagab.entity.relationships.listorder.model.Department;
import org.bagab.entity.relationships.listorder.model.Employee;
import org.bagab.entity.relationships.listorder.model.PrintItem;
import org.bagab.entity.relationships.listorder.model.PrintQueue;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class PrinttService {
    public static Logger log = Logger.getLogger(PrinttService.class.getName());

    @PersistenceContext(name = "test-relationships")
    private EntityManager em;

    /**
     * Create queue
     * @param name
     * @return
     */
    public PrintQueue createQueue(String name) {
        log.info("Create PrintQueue");
        PrintQueue e = new PrintQueue();
        e.setName(name);
        em.persist(e);
        return e;
    }

    /**
     * Find queue by name
     */
    public PrintQueue findQueue(String name) {
        log.info("Find PrintQueue");
        return em.find(PrintQueue.class, name);
    }

    /**
     * Create PrintItem and push it into the queue
     * @param queueName
     * @param job
     * @return
     */
    public PrintItem sendToPrint(String queueName, String job) {
        log.info("Send item to Queue");

        PrintQueue q = em.find(PrintQueue.class, queueName);
        PrintItem i = new PrintItem();
        em.persist(i);
        i.setPrintOrder(q.nextPrintOrderValue());
        i.setJob(job);
        i.setQueue(q);
        q.getJobs().add(i);
        return i;
    }

    /**
     * Pops item out of the queue
     * @param queueName
     * @return
     */
    public PrintItem nextItem(String queueName) {
        PrintQueue q = em.find(PrintQueue.class, queueName);
        List<PrintItem> items = q.getJobs();
        if (items == null || items.isEmpty() )
            return null;

        PrintItem i = items.get(0);
        i = em.merge(i);
        em.remove(i);
        i.getQueue().getJobs().remove(i);
        return i;
    }

}
