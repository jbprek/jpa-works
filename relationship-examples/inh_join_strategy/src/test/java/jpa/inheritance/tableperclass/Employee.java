package jpa.inheritance.tableperclass;

import javax.persistence.*;

/**
 * Root class of the hierarchy
 */

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="EMP_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Employee {

    @Id
    @GeneratedValue
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}



