package jpa.callbacks.test;



import jpa.callbacks.model.Employee;
import jpa.callbacks.service.JPAServiceBean;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by x on 5/1/15.
 */
@RunWith(Arquillian.class)
public class JPAServiceBeanTest {

    @EJB
    private JPAServiceBean svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Employee
        Employee e1 = svc.createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", svc.findEmployee(e1.getId()).getName());

        Employee e2 = svc.update(e1.getId(), "JOHN");
        Assert.assertEquals("JOHN", svc.findEmployee(e2.getId()).getName());

        Employee dead = svc.createEmployee("Dead can dance");
        svc.delete(dead);
        Assert.assertNull(svc.findEmployee(dead.getId()));

    }

}
