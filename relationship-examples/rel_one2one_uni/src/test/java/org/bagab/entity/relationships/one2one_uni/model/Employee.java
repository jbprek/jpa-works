package org.bagab.entity.relationships.one2one_uni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="OOU_EMPLOYEE")
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    @OneToOne
//    @JoinColumn(name = "PARKING_ID")
    private ParkingLotEntity parkingLot;

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

    public ParkingLotEntity getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotEntity parkingLot) {
        this.parkingLot = parkingLot;
    }
}
