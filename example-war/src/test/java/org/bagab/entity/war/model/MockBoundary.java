package org.bagab.entity.war.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author prekezes.
 */
@Stateless
public class MockBoundary {

    @PersistenceContext(unitName="test-pu")
    protected EntityManager em;

    public Employee createEmployee( String name, long salary) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }
    public void removeEmployee(int id) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            em.remove(emp);
        }
    }
    public Employee changeEmployeeSalary(int id, long newSalary) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            emp.setSalary(newSalary);
        }
        return emp;
    }

    public Employee findEmployee(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees() {
        TypedQuery query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
