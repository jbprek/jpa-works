package org.bagab.entity.relationships.one2one_uni.test;

import org.bagab.entity.relationships.one2one_uni.model.Employee;
import org.bagab.entity.relationships.one2one_uni.model.ParkingLotEntity;
import org.bagab.entity.relationships.one2one_uni.service.OneToOneUniService;
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
public class OneToOneUniTest {

    @EJB
    private OneToOneUniService svc;

    @Test
    @OperateOnDeployment("test-suite")
    public void test() {
        // Create Employee
        Employee e1 = svc.createEmployee("John");
        // Lookup Employee by id
        Assert.assertEquals("John", svc.findEmployee(e1.getId()).getName());

        // Create ParkingLotEntity
        ParkingLotEntity l1 = svc.createParkingLot("P1");
        // Lookup ParkingLotEntity by id
        Assert.assertEquals("P1", svc.findLot(l1.getId()).getName());

        // Associate Parking with Employee
        svc.parkingAssign(e1.getId(), l1.getId());
        // Verify Association
        Assert.assertEquals("P1", svc.findEmployee(e1.getId()).getParkingLot().getName());

        // Disasociatate Parking with Employee
        svc.freeParkingLot(e1.getId());
        // Verify Association
        Assert.assertNull( svc.findEmployee(e1.getId()).getParkingLot());


        /** See what happens when we try to assign another employee to a used parking */
        // Associate again e1 to l1
        svc.parkingAssign(e1.getId(), l1.getId());

        Employee e2 = svc.createEmployee("George");
        svc.parkingAssign(e2.getId(), l1.getId());
        Assert.assertEquals("P1", svc.findEmployee(e1.getId()).getParkingLot().getName());
        Assert.assertEquals("P1", svc.findEmployee(e2.getId()).getParkingLot().getName());
        /* OOPS BOTH John and George are assigned to P1, JPA doesn't prevent this */
        /* We must either create and index on the FK column, or do extra work in the code */
    }



}
