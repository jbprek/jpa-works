package jpa.relationship.mapuse.many2many;

import javax.persistence.*;
import java.util.*;

/**
 * @author prekezes.
 */

@Table(name = "EMPLOYEE")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy="employeesByAssignment")
    private Collection<Project> projects = new HashSet<>();

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

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
