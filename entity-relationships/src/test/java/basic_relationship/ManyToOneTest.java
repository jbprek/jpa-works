package basic_relationship;

import basic_relationship.many2one.Soldier;
import basic_relationship.many2one.Unit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;


public class ManyToOneTest {

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
        EntityTransaction tx = beginTx();
        Unit unit = new Unit();
        unit.setName("unit");
        em.persist(unit);
        Soldier s1 = new Soldier();
        s1.setName("s1");
        s1.setUnit(unit);
        em.persist(s1);
        Soldier s2 = new Soldier();
        s2.setName("s2");
        s2.setUnit(unit);
        em.persist(s2);
        tx.commit();

        Soldier s = em.find(Soldier.class, s1.getId());
        Assert.assertEquals(s1.getId(), s.getId());
        String unitName = s.getUnit().getName();
        Assert.assertEquals("unit", unitName);

        s = em.find(Soldier.class, s2.getId());
        Assert.assertEquals(s2.getId(), s.getId());
        unitName = s.getUnit().getName();
        Assert.assertEquals("unit",unitName);
    }
}
