package org.bagab.entity.relationships.many2one;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Single value association
 */
@Entity
//@Table(name="MOU_DEPARTMENT")
public class Department {
    @Id private long id;

    private String name;


}
