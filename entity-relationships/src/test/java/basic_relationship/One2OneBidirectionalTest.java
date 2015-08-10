package basic_relationship;


import basic_relationship.one2one_bi.Customer;
import basic_relationship.one2one_bi.Room;
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
public class One2OneBidirectionalTest {


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

    public Customer findCustomer(long id) {
        return em.find(Customer.class, id);
    }

    public Room createRoom() {
        EntityTransaction tx  = beginTx();
        Room room = new Room();
        em.persist(room);
        tx.commit();
        return room;
    }

    public Room findRoom(long id) {
        return em.find(Room.class, id);
    }

    public void reserveRoom(String name, long roomId) {
        EntityTransaction tx  = beginTx();
        Customer customer = new Customer();
        customer.setName(name);
        em.persist(customer);
        Room room  = findRoom(roomId);
        room.setCustomer(customer);
        customer.setRoom(room);
        tx.commit();
    }

    public void freeRoom(long roomId){
        EntityTransaction tx  = beginTx();
        Room r = findRoom(roomId);
        Customer c = r.getCustomer();
        em.remove(c);
        r.setCustomer(null);
        tx.commit();
    }

    @Test
    public void test() {

        // Create Room 1
        Room room1 = createRoom();

        // Create Room 2
        Room room2 = createRoom();

        // Lookup Room by id
        Assert.assertEquals(room1.getId(), findRoom(room1.getId()).getId());
        Assert.assertEquals(room2.getId(), findRoom(room2.getId()).getId());


        // Reserve Room 1
        reserveRoom("John", room1.getId());
        Customer john = room1.getCustomer();
        Assert.assertEquals("John", room1.getCustomer().getName());
        Assert.assertEquals(room1.getCustomer().getId(), john.getId());

        // Free room
        freeRoom(room1.getId());
        // Verify Association
        Assert.assertNull(findRoom(room1.getId()).getCustomer());

        /* Everything went smoothly since reserveRoom() has the provision to unassign the previous Customer*/
    }
}
