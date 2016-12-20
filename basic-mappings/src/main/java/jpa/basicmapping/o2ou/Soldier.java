package jpa.basicmapping.o2ou;

import javax.persistence.*;

/**
 * @author prekezes.
 */

@Table(name="SOLDIER")
@Entity
public class Soldier {
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    // optional attribute default=true
    @OneToOne
    private Gun gun;



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

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
