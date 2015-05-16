package jpa.relationship.collectionmapping.basickey.emumkey.test;


import jpa.relationship.collectionmapping.basickey.emumkey.model.PersonEnumPhoneType;
import jpa.relationship.collectionmapping.basickey.emumkey.model.PhoneType;
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


public class TestPersonEnumPhoneType {
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

    private PersonEnumPhoneType createEmployee(String name) {
        PersonEnumPhoneType person = new PersonEnumPhoneType();
        person.setName(name);

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        return person;
    }

    private PersonEnumPhoneType findEmployee(long id) {
        return em.find(PersonEnumPhoneType.class, id);
    }

    private void givePhone(PersonEnumPhoneType person, PhoneType phoneType, String phone) {
        Map<PhoneType, String> phones = person.getPhoneNumbers();
        phones.put(phoneType, phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private void takeAwayPhone(PersonEnumPhoneType person, String phone) {
        Map<PhoneType, String> phones = person.getPhoneNumbers();
        phones.remove(phone);

        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    private Map<PhoneType, String> listEmployeePhones(PersonEnumPhoneType person) {
        return person.getPhoneNumbers();
    }


    @Test
    public void test() {
        PersonEnumPhoneType peter = createEmployee("peter");
        givePhone(peter, PhoneType.HOME, "2108076778");
        givePhone(peter, PhoneType.MOBILE, "2108076779");

        Map<PhoneType, String> phones = peter.getPhoneNumbers();
        // Detach phones.size()
        for (PhoneType phoneType : phones.keySet())
            System.out.println(phoneType  + ":" +phones.get(phoneType));
    }

}
