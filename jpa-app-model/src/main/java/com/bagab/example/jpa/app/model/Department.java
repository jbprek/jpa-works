package com.bagab.example.jpa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")

public class Department {

    @Id
    private long id;
    private String name;
    @OneToMany(mappedBy="department")
    private Set<Employee> employees = new HashSet<Employee>();

    public long getId() {
        return id;
    }

    public void setId(long deptNo) {
        this.id = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String deptName) {
        this.name = deptName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public String toString() {
        return "Department no: " + getId() +
               ", name: " + getName();
    }
}
