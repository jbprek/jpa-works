package jpa.relationship.mapuse.stringkey.test;


import jpa.relationship.mapuse.stringkey.model.PersonS;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

/**
 * Created by x on 5/16/15.
 */

public class TestPerson {
    private static EntityManagerFactory entityManagerFactory;
    private static  EntityManager em;

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

    private PersonS createEmployee(String name) {
        PersonS person = new PersonS();
        person.setName(name);

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        return person;
    }

    private PersonS findEmployee(long id) {
        return em.find(PersonS.class, id);
    }

    private void givePhone(PersonS person, String phoneType, String phone) {
        Map<String, String> phones = person.getPhoneNumbers();
        phones.put(phoneType, phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private void takeAwayPhone(PersonS person, String phone) {
        Map<String, String> phones = person.getPhoneNumbers();
        phones.remove(phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private Map<String, String> listEmployeePhones(PersonS person) {
        return person.getPhoneNumbers();
    }


    @Test
    public void test() {
        PersonS peter = createEmployee("peter");
        givePhone(peter, "MOBILE", "2108076778");
        givePhone(peter, "HOME", "2108076779");

        Map<String, String> phones = peter.getPhoneNumbers();
        // Detach phones.size()
        for (String phoneType : phones.keySet()) {
            System.out.println(phoneType  + ":" +phones.get(phoneType));

        }
    }

}
