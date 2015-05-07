package org.bagab.entity.relationships.many2one;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class ManyToOneService {
    public static Logger log = Logger.getLogger(ManyToOneService.class.getName());


    @PersistenceContext(name = "test-relationships")
    private EntityManager em;


    public Employee createEmployee(String name) {
        log.info("Create Employee");
        Employee e = new Employee();
        e.setName(name);
        em.persist(e);
        return e;
    }

    public Employee findEmployee(long id) {
        log.info("Find Employee");
        return em.find(Employee.class, id);
    }

    public Department createDepartment(String name) {
        log.info("Create Department");
        Department e = new Department();
        e.setName(name);
        em.persist(e);
        return e;
    }

    public Department findDepartment(long id) {
        log.info("Find Department");
        return em.find(Department.class, id);
    }

    public void departmentAssign(long employeeId, long departmentId) {
        log.info("Assign ParkingLot");
        Employee e = findEmployee(employeeId);
        Department d  = findDepartment(departmentId);
        Objects.nonNull(d);
        e.setDepartment(d);
    }



}
