package org.bagab.entity.relationships.test;

import org.bagab.entity.relationships.one2many_uni.Person;
import org.bagab.entity.relationships.one2many_uni.Phone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by x on 5/4/15.
 */
@Stateless
public class OneToManyUniService {
    public static Logger log = Logger.getLogger(OneToManyUniService.class.getName());
    @PersistenceContext(name = "test-relationships")
    private EntityManager em;


    public Person createPerson(String name){
        log.info("Create Person");
        Person e = new Person();
        e.setName(name);
        em.persist(e);
        return e;
    }

    public Person findPerson(long id) {
        log.info("Find Person");
        return em.find(Person.class, id);
    }

    public Phone createPhone(String number){
        log.info("Create Phone");
        Phone e = new Phone();
        e.setNumber(number);
        em.persist(e);
        return e;
    }
    
    public Phone findPhone(long id){
        log.info("Find Phone");
        return em.find(Phone.class, id);
    }

    public Collection<Phone> findPersonPhones(long personId) {
        Person e = em.find(Person.class, personId);
        Objects.nonNull(e);
        return e.getPhones();
    }

    public void assignPhone(long personId, long phoneId) {
        Person e = findPerson(personId);
        Phone p = findPhone(phoneId);
        e.getPhones().add(p);
    }

    public void unassignPhone(long personId, long phoneId){
        Person e = findPerson(personId);
        Objects.nonNull(e);
        Phone p = findPhone(phoneId);
        Objects.nonNull(e);
        e.getPhones().remove(p);
    }


}
