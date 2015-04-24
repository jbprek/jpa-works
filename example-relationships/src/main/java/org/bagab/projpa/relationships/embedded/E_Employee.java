package org.bagab.projpa.relationships.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Example use of Embeddable object  with attribute overrides
 */
@Entity
@Table(name="EMBEDDED_EMPLOYEE")
public class E_Employee {
    @Id
    private long id;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="state", column=@Column(name="PROVINCE")),
            @AttributeOverride(name="zip", column=@Column(name="POSTAL_CODE"))
    })    private E_Address EAddress;
}