package jpa.relationship.many2one.test;

import jpa.relationship.many2one.model.Employee;
import jpa.relationship.many2one.model.Department;
import jpa.relationship.many2one.service.ManyToOneService;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by x on 5/3/15.
 */
@RunWith(Arquillian.class)
public class ManyToOneTest {

    @EJB
    private ManyToOneService svc;

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

        // Promote george to Inferno
        svc.departmentAssign(george.getId(), inferno.getId());
        // Verify Association
        Assert.assertEquals("Inferno", svc.findEmployee(george.getId()).getDepartment().getName());



    }
}
