package jpa.relationship.many2many_state;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "PROJECT")
@Entity
public class Project {
    @Id
    private long id;

    private String name;

    @OneToMany(mappedBy = "project")
    private Set<ProjectAssignement> projectAssignements = new HashSet<>();

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

    public Set<ProjectAssignement> getProjectAssignements() {
        return projectAssignements;
    }

    public void setProjectAssignements(Set<ProjectAssignement> projectAssignements) {
        this.projectAssignements = projectAssignements;
    }
}
