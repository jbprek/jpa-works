package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OMU_EMPLOYEE")
@Entity
public class OMU_Employee {
    @Id
    private long id;
    private String name;
    private OMU_Department department;

}
