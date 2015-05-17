package jpa.relationship.many2many_uni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Entity
@Table(name = "MMU_PROJECT")
public class Project {
    @Id
    @GeneratedValue
    private long id;

    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
