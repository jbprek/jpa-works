package basic_relationship;


import basic_relationship.one2one_si.Apartment;
import basic_relationship.one2one_si.ParkingLot;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by x on 5/1/15.
 */
public class One2OneSingleTest {


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

    private EntityTransaction  beginTx() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return tx;
    }

    @Test
    public void test() {
        // Create a transaction
        EntityTransaction tx = null;

        // Create Appartement
        tx = beginTx();
        Apartment e1 = new Apartment();
        e1.setCode("A1");
        em.persist(e1);

        // Create ParkingLot
        ParkingLot l1 = new ParkingLot();
        l1.setCode("P1");
        em.persist(l1);

        // Associate Parking with Appartement
        e1.setParkingLot(l1);
        e1 = em.merge(e1);

        tx.commit();

        tx = beginTx();

        // Lookup Appartement by id
        Assert.assertEquals("A1", em.find(Apartment.class, e1.getId()).getCode());

        // Lookup ParkingLot by id
        Assert.assertEquals("P1", em.find(ParkingLot.class, l1.getSn()).getCode());


        // Verify Association
        Apartment test = em.find(Apartment.class, e1.getId());

        Assert.assertEquals("P1", test.getParkingLot().getCode());
        tx.commit();

        // Dis-associate Parking with Appartement
        tx = beginTx();
        test = em.find(Apartment.class, e1.getId());
        test.setParkingLot(null);
        em.merge(test);
        tx.commit();

        tx = beginTx();
        test = em.find(Apartment.class, e1.getId());
        Assert.assertEquals(null, test.getParkingLot());
        tx.commit();


    }
}
