package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="OMU_PHONE")
public class OMU_Phone {
    @Id
    private long id;
    private String category;
    private String phone;
}
