package org.bagab.projpa.relationships.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Example use of Embeddable object
 */
@Entity
@Table(name="EMBEDDED_COMPANY")
public class E_Company {
    @Id
    private long id;
    private String name;
    @Embedded
    private E_Address EAddress;
}
