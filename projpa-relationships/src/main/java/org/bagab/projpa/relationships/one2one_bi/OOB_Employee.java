package org.bagab.projpa.relationships.one2one_bi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Table(name="ONE_TO_ONE_BI_EMPLOYEE")
@Entity
public class OOB_Employee {
    @Id
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "PARKING_ID")
    private OOB_ParkingLot OOBParkingLot;

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

    public OOB_ParkingLot getOOBParkingLot() {
        return OOBParkingLot;
    }

    public void setOOBParkingLot(OOB_ParkingLot OOBParkingLot) {
        this.OOBParkingLot = OOBParkingLot;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + OOBParkingLot +
                '}';
    }
}
