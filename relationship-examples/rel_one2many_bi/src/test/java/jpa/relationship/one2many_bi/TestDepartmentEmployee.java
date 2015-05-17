package jpa.relationship.one2many_bi;

import jpa.relationship.one2many_bi.Department;
import jpa.relationship.one2many_bi.Employee;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by x on 5/17/15.
 */
public class TestDepartmentEmployee {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;


    @BeforeClass
    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test-relationships");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if (em != null)
            em.close();
        entityManagerFactory.close();
    }


    private Department createDepartment(String name) {
        Department d = new Department();
        d.setName(name);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(d);
        tx.commit();

        return d;
    }


    private Employee createEmployee(String name, Department department) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.getDepartment().getEmployees().add(employee);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(employee);
        tx.commit();

        return employee;
    }

    private Employee fireEmployee(Employee employee) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee e = em.merge(employee);
        e.getDepartment().getEmployees().remove(e);
        em.remove(employee);

        tx.commit();

        return e;
    }

    private Employee changeDepartment(Employee employee, Department newDepartment) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee e = em.merge(employee);
        e.getDepartment().getEmployees().remove(e);
        e.setDepartment(newDepartment);
        newDepartment.getEmployees().add(e);
        tx.commit();

        return e;
    }

    @Test
    public void test() {
        Department hell = createDepartment("hell");
        Department inferno = createDepartment("inferno");

        Employee john = createEmployee("john", hell);
        Employee george = createEmployee("george", hell);

        List<Employee> hellList = hell.getEmployees();
        List<Employee> infernoList = inferno.getEmployees();

        System.out.println(hellList);
        Assert.assertEquals(2, hellList.size());
        Assert.assertTrue(hellList.contains(john));
        Assert.assertTrue(hellList.contains(george));

        Employee peter = createEmployee("peter", hell);
        Assert.assertTrue(hellList.contains(peter));
        Assert.assertEquals(3, hellList.size());

        fireEmployee(john);
        Assert.assertFalse(hellList.contains(john));
        Assert.assertEquals(2, hellList.size());


        changeDepartment(peter, inferno);
        Assert.assertFalse(hellList.contains(peter));
        Assert.assertTrue(infernoList.contains(peter));
        Assert.assertEquals(1, hellList.size());
        Assert.assertEquals(1, infernoList.size());

    }


}
