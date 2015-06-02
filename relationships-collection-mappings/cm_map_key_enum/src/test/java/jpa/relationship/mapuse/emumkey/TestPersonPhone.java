package jpa.relationship.mapuse.emumkey;


import jpa.relationship.mapuse.emumkey.Person;
import jpa.relationship.mapuse.emumkey.PhoneType;
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


public class TestPersonPhone {
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

    private Person createEmployee(String name) {
        Person person = new Person();
        person.setName(name);

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        return person;
    }

    private Person findEmployee(long id) {
        return em.find(Person.class, id);
    }

    private void givePhone(Person person, PhoneType phoneType, String phone) {
        Map<PhoneType, String> phones = person.getPhoneNumbers();
        phones.put(phoneType, phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private void takeAwayPhone(Person person, String phone) {
        Map<PhoneType, String> phones = person.getPhoneNumbers();
        phones.remove(phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private Map<PhoneType, String> listEmployeePhones(Person person) {
        return person.getPhoneNumbers();
    }


    @Test
    public void test() {
        Person peter = createEmployee("peter");
        givePhone(peter, PhoneType.HOME, "2108076778");
        givePhone(peter, PhoneType.MOBILE, "2108076779");

        Map<PhoneType, String> phones = peter.getPhoneNumbers();
        // Detach phones.size()
        for (PhoneType phoneType : phones.keySet())
            System.out.println(phoneType  + ":" +phones.get(phoneType));
    }

}
