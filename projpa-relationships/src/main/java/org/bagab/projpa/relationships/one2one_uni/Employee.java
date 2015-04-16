package org.bagab.projpa.relationships.one2one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Table(name="ONE_TO_ONE_UNI_EMPLOYEE")
@Entity
public class Employee {
    @Id
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "PARKING_ID")
    private ParkingLot parkingLot;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + parkingLot +
                '}';
    }
}
