package org.bagab.entity.relationships.test;

import org.bagab.entity.relationships.one2many_uni.Person;
import org.bagab.entity.relationships.one2many_uni.Phone;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 5/4/15.
 */
@RunWith(Arquillian.class)
public class OneToManyUniTest {
    @EJB
    private OneToManyUniService svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Person john
        Person john = svc.createPerson("John");
        Assert.assertEquals("John", svc.findPerson(john.getId()).getName());

        // Create Person george
        Person george = svc.createPerson("George");
        Assert.assertEquals("George", svc.findPerson(george.getId()).getName());

        // Create Phone phone0
        Phone phone0 = svc.createPhone("000");
        Assert.assertEquals("000", svc.findPhone(phone0.getId()).getNumber());

        // Create Phone phone1
        Phone phone1 = svc.createPhone("111");
        Assert.assertEquals("111", svc.findPhone(phone1.getId()).getNumber());

        // Create Phone phohe2
        Phone phone2 = svc.createPhone("222");
        Assert.assertEquals("222", svc.findPhone(phone2.getId()).getNumber());

        // Assign phones 0 and 1 to johnb
        svc.assignPhone(john.getId(), phone0.getId());
        svc.assignPhone(john.getId(), phone1.getId());

        Person xj = svc.findPerson(john.getId());
        Assert.assertEquals(2, xj.getPhones().size());
        List<String> phones = new ArrayList<>();
        for (Phone e : xj.getPhones())
            phones.add(e.getNumber());
        Assert.assertTrue(phones.contains(phone0.getNumber()));
        Assert.assertTrue(phones.contains(phone1.getNumber()));

        // Assign phone 2 to george
        svc.assignPhone(george.getId(), phone2.getId());

        Person xg = svc.findPerson(george.getId());
        Assert.assertEquals(1, xg.getPhones().size());
        phones = new ArrayList<>();
        for (Phone e : xg.getPhones())
            phones.add(e.getNumber());
        Assert.assertTrue(phones.contains(phone2.getNumber()));

        // Assign phone1 to george

        // Assign phone2 to john

    }
}
