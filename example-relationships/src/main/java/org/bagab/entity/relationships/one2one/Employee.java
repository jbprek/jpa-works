package org.bagab.entity.relationships.one2one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author prekezes.
 */
//@Table(name="OOB_EMPLOYEE")
@Entity
public class Employee {
    @Id
    private long id;

    private String name;

    @OneToOne
//    @JoinColumn(name = "PARKING_ID")
    private ParkingLot parkingLot;


}
