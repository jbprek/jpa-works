package jpa.relationship.elementcollection.test;

import jpa.relationship.elementcollection.model.Employee;
import jpa.relationship.elementcollection.model.VacationEntry;
import jpa.relationship.elementcollection.service.ServiceBean;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by x on 5/1/15.
 */
@RunWith(Arquillian.class)
public class ServiceBeanTest {

    @EJB
    private ServiceBean svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Employee
        Employee john = svc.createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", svc.findEmployee(john.getId()).getName());
//
//        // Add nickNames FOX LIZARD
//        svc.addNickName(john.getId(), "FOX");
//        svc.addNickName(john.getId(), "LIZARD");
//
//        Collection<String> nickNames = svc.getNickNames(john.getId());
//        Assert.assertEquals(2, nickNames.size());
//        Assert.assertTrue(nickNames.contains("FOX"));
//        Assert.assertTrue(nickNames.contains("LIZARD"));

        // Add Vacation Entries for John
        Calendar c = Calendar.getInstance();
        c.set(2014, 11, 5);
        svc.addVacationEntry(john.getId(), c.getTime(), 4);

        c = Calendar.getInstance();
        c.set(2015, 11, 5);
        svc.addVacationEntry(john.getId(), c.getTime(), 5);

        Collection<VacationEntry> vacEntries = svc.getVacationEntries(john.getId());
        System.out.println(vacEntries);
        Assert.assertEquals(2, vacEntries.size());




    }



}
