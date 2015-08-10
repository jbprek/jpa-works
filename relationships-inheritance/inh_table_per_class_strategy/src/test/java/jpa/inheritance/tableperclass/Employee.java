package jpa.inheritance.tableperclass;

import javax.persistence.*;
import java.util.Date;

/**
 * Root class of the hierarchy
 */

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

    @Id
//    @GeneratedValue
    private long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date startDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



}



