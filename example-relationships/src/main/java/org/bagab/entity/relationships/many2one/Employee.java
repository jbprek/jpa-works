package org.bagab.entity.relationships.many2one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
//@Table(name="MOU_EMPLOYEE")
@Entity
public class Employee {
    @Id
    private long id;
    private String name;
    @ManyToOne
//    @JoinColumn(name = "DEPT_ID")
    private Department MOUDepartment;

  // GET SET
}
