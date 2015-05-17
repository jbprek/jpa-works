package jpa.relationship.mapuse.basickey.one2many.model;

import javax.persistence.*;

@Entity
@Table(name="CMM_BK_O2M_EMP")
public class O2MEmployee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    @ManyToOne
    private O2MDepartment department;

    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public O2MDepartment getDepartment() {
        return department;
    }
    
    public void setDepartment(O2MDepartment department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "O2MEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';
    }
}