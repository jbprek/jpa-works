package jpa.relationship.listorder;

import jpa.relationship.listorder.Department;
import jpa.relationship.listorder.Employee;
import org.junit.*;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 5/16/15.
 */


public class TestEmployeeDepartment {
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

    private Department createDepartment(String name) {
        Department d = new Department();
        d.setName(name);
        d.setEmployees(new ArrayList<>());
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();

        return d;
    }

    private Employee createEmployee(String name, Department department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.getDepartment().getEmployees().add(employee);

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        return employee;
    }

    private void fire(Employee e){
        em.getTransaction().begin();
        Department d = e.getDepartment();
        d.getEmployees().remove(e);
        em.remove(e);
        em.getTransaction().commit();
    }


    private Employee findEmployee(long id) {
        return em.find(Employee.class, id);
    }

    private Department findDepartment(long id) {
        return em.find(Department.class , id);
    }

    List<Employee> listEmployees(Department department) {
        return em.createQuery("SELECT d.employees FROM Department d where d ").getResultList();    }


    private void changeDepartment(Employee e, Department department) {
        em.getTransaction().begin();
        Department old = e.getDepartment();
        old.getEmployees().remove(e);
        e.setDepartment(department);
        e.getDepartment().getEmployees().add(e);
        em.getTransaction().commit();
    }


    @Test
    public void test() {
        Department hell = createDepartment("hell");
        Department inferno = createDepartment("inferno");
        Employee peter = createEmployee("peter", hell);
        Employee adam = createEmployee("adam", hell);
        Employee george = createEmployee("george", hell);

        Department d = findDepartment(hell.getId());
        for (Employee e : d.getEmployees()){
            System.out.println(e);
        }

        System.out.println(d.getEmployees());


    }


}
