package jpa.relationship.elementcollection;

import jpa.relationship.elementcollection.Employee;
import jpa.relationship.elementcollection.VacationEntry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by x on 5/17/15.
 */
public class TestRelationship {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setup(){
        entityManagerFactory = Persistence.createEntityManagerFactory("test-relationships");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if ( em != null)
            em.close();
        entityManagerFactory.close();
    }

    private Employee createEmployee(String name) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Employee emp = new Employee();
        emp.setName(name);
        em.persist(emp);
        tx.commit();

        return emp;
    }

    private Employee findEmployee(long id) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Employee emp = em.find(Employee.class, id);
        tx.commit();

        return emp;
    }


    private void addNickName(Employee e, String nickname) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        e.getNickNames().add(nickname);
        tx.commit();
    }

    private void removeNickName(Employee e, String nickName) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        e.getNickNames().remove(nickName);

        tx.commit();

    }


    private void addVacationEntry(Employee e, LocalDate startDate, int duration) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        VacationEntry v = new VacationEntry();

        Instant it = startDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        v.setStartDate(Date.from(it));
        v.setDuration(duration);
        e.getVacationEntries().add(v);

        tx.commit();

    }

    @Test
    public void test() {
        Employee john = createEmployee("john");
        List<VacationEntry> daysOf = john.getVacationEntries();
        List<String> nickNames = john.getNickNames();

        addVacationEntry(john, LocalDate.of(2015, 10, 11), 3);

        addVacationEntry(john, LocalDate.of(2014, 10, 11), 3);
        addNickName(john, "Master");
        addNickName(john, "Blaster");

        Employee found = findEmployee(john.getId());

        System.out.println(found.getVacationEntries());

        System.out.println(found.getNickNames());
    }
}
