package org.bagab.projpa.relationships.one2one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Table(name="ONE_TO_ONE_UNI_EMPLOYEE")
@Entity
public class OOU_Employee {
    @Id
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "PARKING_ID")
    private OOU_ParkingLot OOUParkingLot;

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

    public OOU_ParkingLot getOOUParkingLot() {
        return OOUParkingLot;
    }

    public void setOOUParkingLot(OOU_ParkingLot OOUParkingLot) {
        this.OOUParkingLot = OOUParkingLot;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + OOUParkingLot +
                '}';
    }
}
