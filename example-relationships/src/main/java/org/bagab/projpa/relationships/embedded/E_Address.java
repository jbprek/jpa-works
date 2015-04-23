package org.bagab.projpa.relationships.embedded;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


/**
 * Example of an Embeddable object
 */
@Embeddable @Access(AccessType.FIELD)
public class E_Address {
    private String street;
    private String number;
    private String state;
    private String zip;
    private String county;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "E_Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
