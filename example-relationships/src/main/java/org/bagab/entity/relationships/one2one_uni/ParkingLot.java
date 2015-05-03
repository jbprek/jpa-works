package org.bagab.entity.relationships.one2one_uni;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity(name = "org.bagab.entity.relationships.one2one_uni.ParkingLot")
@Table(name="OOU_PARKING_LOT")
public class ParkingLot {
    @GeneratedValue
    @Id private long id;

    @Basic(optional = false)
    private String name;


    //--------  Get Set-----------------


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
}
