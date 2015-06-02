package jpa.relationship.one2many_uni;

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


}
