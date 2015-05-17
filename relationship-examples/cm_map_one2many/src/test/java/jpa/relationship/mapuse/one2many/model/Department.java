package jpa.relationship.mapuse.one2many.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author prekezes.
 */
@Entity
@Table(name="OMB_DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    private List<Employee> employees;

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
}
