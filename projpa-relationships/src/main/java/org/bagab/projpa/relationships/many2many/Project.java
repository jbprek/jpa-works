package org.bagab.projpa.relationships.many2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
@Table(name="MANY_TO_MANY_PROJ")
public class Project {
    @Id
    private long id;

    private String name;

    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> employees;
}
