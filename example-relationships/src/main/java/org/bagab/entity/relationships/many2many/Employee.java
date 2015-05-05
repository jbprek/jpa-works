package org.bagab.entity.relationships.many2many;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * @author prekezes.
 */
@Table(name = "MM_EMPLOYEE")
@Entity(name="org.bagab.entity.relationships.many2many.Employee")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "MM_EMP_PROJ", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
    private Set<Project> projects;


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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    /*----------- hashCode and equals ----------------- */
    /* NOTE do not include relation */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return name.equals(employee.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
