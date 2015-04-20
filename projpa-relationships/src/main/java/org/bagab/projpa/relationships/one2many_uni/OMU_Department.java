package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author prekezes.
 */
@Entity
public class OMU_Department {
    @Id
    private long id;
    private String name;
}
