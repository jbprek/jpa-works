package jpa.relationship.mapuse.one2many;

import jpa.relationship.mapuse.one2many.Department;
import jpa.relationship.mapuse.one2many.Employee;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;

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


    private Employee createEmployee(String name, Department department, String cubicle) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.getDepartment().getEmployeesByCubicle().put(cubicle, employee);

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
        e.getDepartment().getEmployeesByCubicle().values().remove(e);
        em.remove(employee);

        tx.commit();

        return e;
    }

    private Employee changeDepartment(Employee employee, Department newDepartment, String cubicle) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee e = em.merge(employee);
        e.getDepartment().getEmployeesByCubicle().values().remove(e);
        e.setDepartment(newDepartment);
        newDepartment.getEmployeesByCubicle().put(cubicle, e);
        tx.commit();

        return e;
    }

    @Test
    public void test() {
        Department hell = createDepartment("hell");
        Department inferno = createDepartment("inferno");

        Employee john = createEmployee("john", hell, "001");
        Employee george = createEmployee("george", hell, "002");

        Map<String, Employee> hellMap = hell.getEmployeesByCubicle();
        Map<String, Employee> infernoMap = inferno.getEmployeesByCubicle();

        System.out.println(hellMap);
        Assert.assertEquals(2, hellMap.size());
        Assert.assertTrue(hellMap.values().contains(john));
        Assert.assertTrue(hellMap.values().contains(george));

//        Employee peter = createEmployee("peter", hell);
//        Assert.assertTrue(hellMap.contains(peter));
//        Assert.assertEquals(3, hellMap.size());
//
//        fireEmployee(john);
//        Assert.assertFalse(hellMap.contains(john));
//        Assert.assertEquals(2, hellMap.size());
//
//
//        changeDepartment(peter, inferno);
//        Assert.assertFalse(hellMap.contains(peter));
//        Assert.assertTrue(infernoList.contains(peter));
//        Assert.assertEquals(1, hellMap.size());
//        Assert.assertEquals(1, infernoList.size());

    }


}
