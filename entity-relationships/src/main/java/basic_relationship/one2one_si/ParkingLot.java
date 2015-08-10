package basic_relationship.one2one_si;

import javax.persistence.*;

/**
 * Created by john on 8/8/15.
 */
@Entity
public class ParkingLot {
    @Id
    private long sn;

    @Basic(optional = false)
    private String code;



    // -------- GET/SET ---------------

    public long getSn() {
        return sn;
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
