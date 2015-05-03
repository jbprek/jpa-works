package org.bagab.entity.collectionmapping.list.order_by_entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private Department department;

  // GET SET
}
