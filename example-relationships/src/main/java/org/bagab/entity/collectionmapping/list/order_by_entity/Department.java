package org.bagab.entity.collectionmapping.list.order_by_entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

/**
 * Single value association
 */
@Entity(name="org.bagab.entity.collectionmapping.list.order_by_entity.Department")
@Table(name="CMLOE_DEPARTMENT")
public class Department {
    @Id private long id;

    private String name;

    @OneToMany(mappedBy = "department")
    /* ASC is the default so it's reeundant */
    @OrderBy("name ASC")
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
