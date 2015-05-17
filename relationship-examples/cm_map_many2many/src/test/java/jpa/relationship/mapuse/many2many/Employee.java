package jpa.relationship.mapuse.many2many;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "MMB_EMPLOYEE")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MMB_EMPLOYEE_PROJECT", joinColumns = @JoinColumn(name="EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
    private Set<Project> projects;

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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
