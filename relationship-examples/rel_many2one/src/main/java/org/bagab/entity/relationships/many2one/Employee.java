package org.bagab.entity.relationships.many2one;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="MOU_EMPLOYEE")
public class Employee {

    @GeneratedValue
    @Id
    private long id;

    @Basic(optional=false)
    private String name;

    @ManyToOne
//    @JoinColumn(name = "DEPT_ID")
    private Department department;

    //----------- GET/SET --------------------------


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
