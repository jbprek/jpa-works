package jpa.basicmapping.o2mb;

import javax.persistence.*;

/**
 * @author prekezes.
 */

@Table(name="EMPLOYEE")
@Entity
public class Employee {

    @Id
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;

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

    public jpa.basicmapping.o2mb.Department getDepartment() {
        return department;
    }

    public void setDepartment(jpa.basicmapping.o2mb.Department department) {
        this.department = department;
    }
}



