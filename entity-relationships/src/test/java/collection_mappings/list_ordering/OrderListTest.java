package collection_mappings.list_ordering;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by x on 5/16/15.
 */


public class OrderListTest {

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
        CustOrder d = new CustOrder();
        d.setName("D1");
        em.persist(d);

        OrderItem a = new OrderItem();
        a.setName("a");
        em.persist(a);

        OrderItem b = new OrderItem();
        b.setName("b");
        em.persist(b);

        OrderItem c = new OrderItem();
        c.setName("c");
        em.persist(c);

        d.getItems().add(b);
        d.getItems().add(a);
        d.getItems().add(c);

        b.setOrder(d);
        a.setOrder(d);
        c.setOrder(d);

        tx.commit();

        CustOrder dc = em.find(CustOrder.class, d.getId());
        for( OrderItem e : dc.getItems())
            System.out.println(e.getName());


    }

}
