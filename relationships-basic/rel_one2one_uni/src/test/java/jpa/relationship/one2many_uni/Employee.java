package jpa.relationship.one2many_uni;

import javax.persistence.*;

/**
 * @author prekezes.
 */

@Table(name="EMPLOYEE")
@Entity
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    // optional attribute default=true
    @OneToOne
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
