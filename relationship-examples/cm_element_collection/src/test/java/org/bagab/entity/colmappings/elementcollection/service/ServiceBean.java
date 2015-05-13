package org.bagab.entity.colmappings.elementcollection.service;



import org.bagab.entity.colmappings.elementcollection.model.Employee;
import org.bagab.entity.colmappings.elementcollection.model.VacationEntry;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
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

    public void addNickName(long employeeId, String nickname) {
        log.info("Adding nickName "+nickname);

        Objects.requireNonNull(nickname);
        Employee e = findEmployee(employeeId);
        Objects.requireNonNull(e);
        e.getNickNames().add(nickname);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> getNickNames(long employeeId) {
        log.info("Getting nickNames");

        Employee e = findEmployee(employeeId);
        Objects.requireNonNull(e);
        List<String> nickName = e.getNickNames();
        return e.getNickNames();
    }

    public void addVacationEntry(long employeeId, Date startDate, int duration) {
        Employee e = findEmployee(employeeId);
        Objects.requireNonNull(e);
        VacationEntry v = new VacationEntry();
    }

    public List<VacationEntry> getVacationEntries(long employeeId) {
        Employee e = findEmployee(employeeId);
        Objects.requireNonNull(e);
        return e.getVacationEntries();
    }
}
