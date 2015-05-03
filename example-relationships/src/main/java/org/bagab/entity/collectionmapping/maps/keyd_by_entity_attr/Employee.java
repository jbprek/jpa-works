package org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr;

import javax.persistence.Column;
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

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
//    @JoinColumn(name = "DEPT_ID")
    private Department MOUDepartment;

  // GET SET
}
