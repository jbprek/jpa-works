package org.bagab.entity.relationships.test;

import org.bagab.entity.relationships.one2many_bi.Department;
import org.bagab.entity.relationships.one2many_bi.Employee;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by x on 5/3/15.
 */
@RunWith(Arquillian.class)
public class OneToManyBiTest {

    @EJB
    private OneToManyBiService svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Employee
        Employee john = svc.createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", svc.findEmployee(john.getId()).getName());

        // Create another Employee
        Employee george = svc.createEmployee("George");
        // Lookup Employee by id
        Assert.assertEquals("George", svc.findEmployee(george.getId()).getName());

        // Create Department
        Department hell = svc.createDepartment("Hell");
        // Lookup Department by id
        Assert.assertEquals("Hell", svc.findDepartment(hell.getId()).getName());

        // Create Another Department
        Department inferno = svc.createDepartment("Inferno");
        // Lookup Department by id
        Assert.assertEquals("Inferno", svc.findDepartment(inferno.getId()).getName());

        // Associate john with Hell
        svc.departmentAssign(john.getId(), hell.getId());
        // Verify Association
        Assert.assertEquals("Hell", svc.findEmployee(john.getId()).getDepartment().getName());

        // Associate george with Hell
        svc.departmentAssign(george.getId(), hell.getId());
        // Verify Association
        Assert.assertEquals("Hell", svc.findEmployee(george.getId()).getDepartment().getName());

        // Verify that john and george are gone to hell
        Collection<Employee> l = svc.getDepartmentEmployees(hell.getId());
        Assert.assertEquals(2,  l.size());

        for (Employee e : l)
            System.out.println("###"+e.getName() + "*"+ e.getId());

        // TODO check why the following two do not work
//        Assert.assertTrue(l.contains(john));
//        Assert.assertTrue(l.contains(george));

        List<String> names = new ArrayList<>();
        for (Employee e : l)
            names.add(e.getName());

        // TODO
        System.out.println("$$$:"+names+ "*"+john.getName()+"^"+george.getName());
        Assert.assertTrue(names.contains(john.getName()));
        Assert.assertTrue(l.contains(george.getName()));


        // Promote george to Inferno
        svc.departmentAssign(george.getId(), inferno.getId());
        // Verify Association
        Assert.assertEquals("Inferno", svc.findEmployee(george.getId()).getDepartment().getName());

    }

    private List<Employee> copy2List(Collection<Employee> employee) {
        ArrayList<Employee> l = new ArrayList<>();
        for(Employee e : employee) {
            l.add(e);
        }
        return l;
    }
}
