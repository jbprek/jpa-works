package basic_relationship.one2one_si;

import javax.persistence.*;

/**
 * Created by john on 8/8/15.
 */
@Entity
public class Appartement {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String code;

    // optional attribute default=true
    @OneToOne(optional=true)
    // if ommited a column with the name parkingLot_sn will be created
    @JoinColumn(name="PARK_SN")
    private ParkingLot parkingLot;

    public Appartement() {
    }

    public Appartement(String code) {
        this.code = code;
    }

    //------------ GET/SET -----------------------

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
