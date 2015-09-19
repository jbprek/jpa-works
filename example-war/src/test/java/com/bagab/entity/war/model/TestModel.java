package com.bagab.entity.war.model;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * @author prekezes.
 */
@RunWith(Arquillian.class)
public class TestModel {
    @EJB
    private MockBoundary dao;

    @Test
    @OperateOnDeployment("test-suite")
    public void testModel() throws Exception {
        Employee e = dao.createEmployee("john", 1000) ;
        Employee f = dao.findEmployee(e.getId());
        Assert.assertEquals(e, f);
    }
}
