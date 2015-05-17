package jpa.relationship.mapuse.many2many;

import javax.persistence.*;
import java.util.*;

/**
 * @author prekezes.
 */

@Table(name = "CM_MMB_PROJECT")
@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "CM_MMB_EMPLOYEE_PROJECT",
            joinColumns = @JoinColumn(name="PROJECT_ID" ),
            inverseJoinColumns = @JoinColumn(name="EMPLOYEE_ID"))
    @MapKeyColumn(name="ASSIGNEMENT")
    private Map<String, Employee> employees = new HashMap<>();

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

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }
}
