package org.bagab.entity.relationships.one2one_bi;

import javax.persistence.*;

/**
 * @author prekezes.
 */

@Table(name="OOB_EMPLOYEE")
@Entity
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    // optional attribute default=true
    @OneToOne
//    @JoinColumn(name = "PARKING_ID")
    private ParkingLot parkingLot;

     //------------ GET/SET -----------------------

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
