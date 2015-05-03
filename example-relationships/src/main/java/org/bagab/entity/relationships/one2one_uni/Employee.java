package org.bagab.entity.relationships.one2one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * @author prekezes.
 */
@Table(name="OOU_EMPLOYEE")
@Entity(name = "org.bagab.entity.relationships.one2one_uni.Employee")
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    @OneToOne
//    @JoinColumn(name = "PARKING_ID")
    private ParkingLot parkingLot;

    //----------- GET/SET --------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
