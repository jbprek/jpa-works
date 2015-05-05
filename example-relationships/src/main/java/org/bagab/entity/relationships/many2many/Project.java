package org.bagab.entity.relationships.many2many;

import javax.persistence.*;
import java.util.Set;

/**
 * @author prekezes.
 */
@Entity(name="org.bagab.entity.relationships.many2many.Project")
@Table(name="MM_PROJECT")
public class Project {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    /**
     * If the following is removed relation is unidirectional
     */
    @ManyToMany(mappedBy = "projects",fetch = FetchType.EAGER)
    private Set<Employee> employees;

    /*---------- GET SET --------------------*/

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    /*----------- hashCode and equals ----------------- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        return name.equals(project.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
