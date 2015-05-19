package jpa.relationship.mapuse.many2many;

import javax.persistence.*;
import java.util.*;

/**
 * @author prekezes.
 */

@Table(name = "PROJECT")
@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_PROJECT",
            joinColumns = @JoinColumn(name="PROJECT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="EMPLOYEE_ID", referencedColumnName = "ID"))
    @MapKeyColumn(name="ASSIGNMENT")
    private Map<String, Employee> employeesByAssignment;

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

    public Map<String, Employee> getEmployeesByAssignment() {
        return employeesByAssignment;
    }

    public void setEmployeesByAssignment(Map<String, Employee> employeesByAssignment) {
        this.employeesByAssignment = employeesByAssignment;
    }
}
