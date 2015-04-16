package org.bagab.projpa.relationships.one2one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="ONE_TO_ONE_UNI_PARKING_LOT")
public class ParkingLot {
    @Id private long id;

    private String lotCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }


    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", lotCode='" + lotCode + '\'' +
                '}';
    }
}
