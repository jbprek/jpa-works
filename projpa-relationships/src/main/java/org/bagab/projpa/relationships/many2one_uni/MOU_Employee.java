package org.bagab.projpa.relationships.many2one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Table(name="MANY_TO_ONE_UNI_EMPLOYEE")
@Entity
public class MOU_Employee {
    @Id
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private MOU_Department MOUDepartment;

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

    public MOU_Department getMOUDepartment() {
        return MOUDepartment;
    }

    public void setMOUDepartment(MOU_Department MOUDepartment) {
        this.MOUDepartment = MOUDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + MOUDepartment +
                '}';
    }
}
