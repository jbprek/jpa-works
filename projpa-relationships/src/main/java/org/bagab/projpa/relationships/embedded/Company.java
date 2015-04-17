package org.bagab.projpa.relationships.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author prekezes.
 */
@Entity(name="EMBEDDED_COMPANY")
public class Company {
    @Id
    private long id;
    private String name;
    @Embedded
    private Address address;
}
