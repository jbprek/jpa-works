package org.bagab.entity.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Example use of Embeddable object
 */
@Entity
@Table(name="E_COMPANY")
public class E_Company {
    @Id
    private long id;
    private String name;
    @Embedded
    private E_Address EAddress;

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

    public E_Address getEAddress() {
        return EAddress;
    }

    public void setEAddress(E_Address EAddress) {
        this.EAddress = EAddress;
    }
}
