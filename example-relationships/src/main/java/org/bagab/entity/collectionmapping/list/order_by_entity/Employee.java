package org.bagab.entity.collectionmapping.list.order_by_entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
//@Table(name="MOU_EMPLOYEE")
@Entity(name="org.bagab.entity.collectionmapping.list.order_by_entity.Employee")
@Table(name="CMLOE_EMPLOYEE")
public class Employee {
    @Id
    private long id;
    private String name;
    @ManyToOne
//    @JoinColumn(name = "DEPT_ID")
    private Department department;

  // GET SET


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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
