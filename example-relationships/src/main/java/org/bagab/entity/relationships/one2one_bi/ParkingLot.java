package org.bagab.entity.relationships.one2one_bi;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity(name = "org.bagab.entity.relationships.one2one_bi.ParkingLot")
@Table(name="OOB_PARKING_LOT")
public class ParkingLot{

    @GeneratedValue
    @Id private long id;

    @Basic(optional = false)
    private String code;

    // If mappedBy is removed then foreign keys are created on both tables
    @OneToOne(mappedBy = "parkingLot")
    private Employee employee;


    // -------- GET/SET ---------------


    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
