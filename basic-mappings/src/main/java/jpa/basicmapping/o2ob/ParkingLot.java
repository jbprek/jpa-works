package jpa.basicmapping.o2ob;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="PARKING_LOT")
public class ParkingLot{

    @GeneratedValue
    @Id private long id;

    @Basic(optional = false)
    private String code;

    // If mappedBy is removed then foreign keys are created on both tables
    @OneToOne//(mappedBy = "parkingLot")
    private Tenant tenant;

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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
