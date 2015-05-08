package org.bagab.entity.relationships.many2many_uni.test;


import org.bagab.entity.relationships.many2many_uni.model.Employee;
import org.bagab.entity.relationships.many2many_uni.model.Project;
import org.bagab.entity.relationships.many2many_uni.service.Many2ManyUniService;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by x on 5/5/15.
 */
@RunWith(Arquillian.class)
public class Many2ManyUniTest {

    @EJB private Many2ManyUniService svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create employees John and George
        Employee john = svc.createEmployee("John");
        Assert.assertEquals("John", svc.findEmployee(john.getId()).getName());

        Employee george = svc.createEmployee("George");
        Assert.assertEquals("George", svc.findEmployee(george.getId()).getName());

        // Create projects Hell and Inferno
        Project hell = svc.createProject("Hell");
        Assert.assertEquals("Hell", svc.findProject(hell.getId()).getName());

        Project inferno = svc.createProject("Inferno");
        Assert.assertEquals("Inferno", svc.findProject(inferno.getId()).getName());

        // Assign John to Hell
        svc.assignToProject(john.getId(), hell.getId());
        Assert.assertEquals(1, svc.findEmployee(john.getId()).getProjects().size());
         Assert.assertTrue(svc.findEmployee(john.getId()).getProjects().contains(hell));

        // Assign George to Inferno
        svc.assignToProject(george.getId(), inferno.getId());
        Assert.assertEquals(1, svc.findEmployee(george.getId()).getProjects().size());
        Assert.assertTrue(svc.findEmployee(george.getId()).getProjects().contains(inferno));

        // Remove John from Hell
        svc.dismissFromProject(john.getId(), hell.getId());
        Assert.assertEquals(0, svc.findEmployee(john.getId()).getProjects().size());
        Assert.assertFalse(svc.findEmployee(john.getId()).getProjects().contains(hell));

        // Assign George to Hell
        svc.assignToProject(george.getId(), hell.getId());
        Assert.assertEquals(2, svc.findEmployee(george.getId()).getProjects().size());

        Assert.assertTrue(svc.findEmployee(george.getId()).getProjects().contains(inferno));
        Assert.assertTrue(svc.findEmployee(george.getId()).getProjects().contains(hell));
    }

}
