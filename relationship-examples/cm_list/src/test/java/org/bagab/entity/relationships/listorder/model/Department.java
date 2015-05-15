package org.bagab.entity.relationships.listorder.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

/**
 * @author prekezes.
 */
@Entity
@Table(name="CML_DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy="department", fetch = FetchType.EAGER)
    @OrderBy("name") //   alternative ("name DESC")
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
