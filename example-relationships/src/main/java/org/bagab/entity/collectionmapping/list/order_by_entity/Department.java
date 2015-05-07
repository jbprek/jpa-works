package org.bagab.entity.collectionmapping.list.order_by_entity;

import javax.persistence.*;
import java.util.List;

/**
 * Single value association
 */
@Entity
@Table(name="_DEPARTMENT")
public class Department {
    @Id private long id;

    private String name;

    @OneToMany(mappedBy = "department")
    /* ASC is the default so it's redundant */
    @OrderBy("name ASC")
    private List<Employee> employees;


}
