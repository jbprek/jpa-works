package jpa.relationship.many2many_state;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "AREL_MMBST_ROJECT")
@Entity
public class Project {
    @Id
    @GeneratedValue
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
}
