package com.bagab.ee7.patterns.dao;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

/**
 * Created by x on 5/2/15.
 */
@RunWith(Arquillian.class)
public class DAOBoundaryTest {
    @EJB
    private DAOBoundary dao;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        TestEntity e = new TestEntity();
        e.setName("John");

        TestEntity e1 = dao.create(e);
        TestEntity e2 = dao.read(e1.getId());
        Assert.assertEquals(e1, e2);

    }
}
