package org.bagab.projpa.relationships.embedded;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="EMBEDDED_EMPLOYEE")
public class Employee {
    @Id
    private long id;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="state", column=@Column(name="PROVINCE")),
            @AttributeOverride(name="zip", column=@Column(name="POSTAL_CODE"))
    })    private Address address;
}
