package org.bagab.entity.collectionmapping.list.order_by_entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

/**
 * Single value association
 */
@Entity
//@Table(name="MOU_DEPARTMENT")
public class Department {
    @Id private long id;

    private String name;

    @OneToMany(mappedBy = "department")
    /* ASC is the default so it's reeundant */
    @OrderBy("name ASC")
    private List<Employee> employees;


}
