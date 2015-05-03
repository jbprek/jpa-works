package org.bagab.entity.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Example use of Embeddable object
 */
@Entity
public class Company {
    @Id
    private long id;
    private String name;
    @Embedded
    private Address EAddress;

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

    public Address getEAddress() {
        return EAddress;
    }

    public void setEAddress(Address EAddress) {
        this.EAddress = EAddress;
    }
}
