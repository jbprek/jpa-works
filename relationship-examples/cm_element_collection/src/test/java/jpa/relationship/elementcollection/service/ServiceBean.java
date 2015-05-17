package jpa.relationship.elementcollection.service;



import jpa.relationship.elementcollection.model.Employee;
import jpa.relationship.elementcollection.model.VacationEntry;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class ServiceBean {
    public static Logger log = Logger.getLogger(ServiceBean.class.getName());

    @PersistenceContext(name = "test-relationships")
    private EntityManager em;

    public Employee createEmployee(String name) {
        log.info("Create Employee");
        Employee emp = new Employee();
        emp.setName(name);
        em.persist(emp);
        return emp;
    }

    public Employee findEmployee(long id) {
        log.info("Find Employee");
        return em.find(Employee.class, id);
    }

//    public void addNickName(long employeeId, String nickname) {
//        log.info("Adding nickName " + nickname);
//
//        Objects.requireNonNull(nickname);
//        Employee e =  em.find(Employee.class, employeeId);
//        Objects.requireNonNull(e);
//        e.getNickNames().add(nickname);
//    }
//
//    public Collection<String> getNickNames(long employeeId) {
//        log.info("Getting nickNames");
//
//        Employee e = em.find(Employee.class, employeeId);
//        Objects.requireNonNull(e);
//        return e.getNickNames();
//    }

    public void addVacationEntry(long employeeId, Date startDate, int duration) {
        log.info("Adding vacation entry");
        Employee e = em.find(Employee.class, employeeId);
        Objects.requireNonNull(e);
        VacationEntry v = new VacationEntry();
        v.setStartDate((Date) startDate.clone());
        v.setDuration(duration);
        e.getVacationEntries().add(v);

    }

    public Collection<VacationEntry> getVacationEntries(long employeeId) {
        log.info("Getting vacation Entries");

        Employee e = em.find(Employee.class, employeeId);
        Objects.requireNonNull(e);
        return e.getVacationEntries();
    }
}
