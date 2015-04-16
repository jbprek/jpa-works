package org.bagab.projpa.relationships.one2one_bi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="ONE_TO_ONE_BI_PARKING_LOT")
public class ParkingLot {
    @Id private long id;

    private String name;

    @OneToOne(mappedBy = "parkingLot")
    private Employee employee;

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

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
