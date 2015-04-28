package org.bagab.entity.war.boundary;

import org.bagab.entity.war.model.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author prekezes.
 */
@Stateless
public class EmployeeService {

    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;


    EntityManager getEntityManager() {
        return em;
    }
    public Employee createEmployee( String name, long salary) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        getEntityManager().persist(emp);
        return emp;
    }
    public void removeEmployee(int id) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            getEntityManager().remove(emp);
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
        return getEntityManager().find(Employee.class, id);
    }

    public List<Employee> findAllEmployees() {
        TypedQuery query = getEntityManager().createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
