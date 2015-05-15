package org.bagab.entity.relationships.listorder.test;

import org.bagab.entity.relationships.listorder.model.*;
import org.bagab.entity.relationships.listorder.service.*;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by x on 5/3/15.
 */
@RunWith(Arquillian.class)
public class PrintServiceTest {

    @EJB
    private PrinttService svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Queue
        PrintQueue hp = svc.createQueue("hp");
        // Lookup Queue by name
        Assert.assertEquals("hp", svc.findQueue("hp").getName());

        // Send 10 Print jobs
        for (int i = 0; i < 10; i++ ) {
            svc.sendToPrint("hp", "Payload " + i);
        }

        // Test results
        hp = svc.findQueue("hp");
        List<PrintItem> items = hp.getJobs();
        Assert.assertEquals(10, items.size());
        for (int i = 0; i < 10; i++ ) {
            Assert.assertEquals("Payload "+i, items.get(i).getJob());
        }

        // Test result pop up
        PrintItem ii;
        int count = 0;
        while((ii = svc.nextItem("hp"))!= null) {
            count++;
        }
        // 10 popped items
        Assert.assertEquals(10, count);
        hp = svc.findQueue("hp");
        items = hp.getJobs();
        Assert.assertEquals(0, items.size());

    }
}
