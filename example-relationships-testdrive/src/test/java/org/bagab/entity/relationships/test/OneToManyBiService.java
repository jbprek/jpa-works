package org.bagab.entity.relationships.test;

import org.bagab.entity.relationships.one2many_bi.Department;
import org.bagab.entity.relationships.one2many_bi.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class OneToManyBiService {
    public static Logger log = Logger.getLogger(OneToManyBiService.class.getName());

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
        log.info("Assign Department");
        Employee e = findEmployee(employeeId);
        Department d = e.getDepartment();
        // Unassign from previous department
        if ( d != null){
            e.setDepartment(null);
            d.getEmployees().remove(e);
        }
        Department nd = findDepartment(departmentId);
        Objects.nonNull(d);
        nd.getEmployees().add(e);
        e.setDepartment(nd);

    }

    public Collection<Employee> getDepartmentEmployees(long departmentId) {
        Department d = findDepartment(departmentId);
        Objects.nonNull(d);
        return d.getEmployees();
    }

}
