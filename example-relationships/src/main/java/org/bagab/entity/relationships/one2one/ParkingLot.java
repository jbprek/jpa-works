package org.bagab.entity.relationships.one2one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author prekezes.
 */
@Entity
//@Table(name="OOB_PARKING_LOT")
public class ParkingLot {
    @Id private long id;

    private String name;

    // If the following is removed we have a unidirectional association
    @OneToOne(mappedBy = "parkingLot")
    private Employee employee;


}
