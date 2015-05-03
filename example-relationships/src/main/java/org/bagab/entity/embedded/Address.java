package org.bagab.entity.embedded;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


/**
 * Example of an Embeddable object
 */
@Embeddable @Access(AccessType.FIELD)
public class Address {
    private String street;
    private String number;
    private String state;
    private String zip;
    private String county;

    // Get set ...
}
