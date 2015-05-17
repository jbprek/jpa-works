package jpa.relationship.mapuse.many2many;

import javax.persistence.*;
import java.util.*;

/**
 * @author prekezes.
 */

@Table(name = "CM_MMB_EMPLOYEE")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy="employees")
    private Set<Project> projectsByAssignement = new HashSet<>();

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

    public Set<Project> getProjectsByAssignement() {
        return projectsByAssignement;
    }

    public void setProjectsByAssignement(Set<Project> projectsByAssignement) {
        this.projectsByAssignement = projectsByAssignement;
    }
}
