package basic_relationship;

import basic_relationship.many2many_bi.BankAccount;
import basic_relationship.many2many_bi.BankCustomer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author prekezes.
 */
public class Many2ManyBiTest {


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

        BankCustomer c1 = new BankCustomer()  ;
        c1.setName("C1");
        em.persist(c1);

        BankCustomer c2 = new BankCustomer()  ;
        c2.setName("C2");
        em.persist(c2);

        BankCustomer c3 = new BankCustomer()  ;
        c3.setName("C3");
        em.persist(c3);

        BankCustomer c4 = new BankCustomer()  ;
        c4.setName("C4");
        em.persist(c4);


        BankAccount a1 = new BankAccount();
        a1.setName("A1");
        em.persist(a1);

        BankAccount a2 = new BankAccount();
        a2.setName("A2");
        em.persist(a2);

        BankAccount a3 = new BankAccount();
        a3.setName("A3");
        em.persist(a3);

        c1.getAccounts().add(a1);
        c2.getAccounts().add(a1);
        a1.getCustomers().add(c1);
        a1.getCustomers().add(c1);

        c3.getAccounts().add(a2);
        a2.getCustomers().add(c3);

        c4.getAccounts().add(a3);
        a3.getCustomers().add(c4);

        tx.commit();

    }
}
