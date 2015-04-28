package org.bagab.entity.relationships.many2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
//@Table(name="MMB_PROJ")
public class Project {
    @Id
    private long id;

    private String name;

    /**
     * If the following is removed relation is unidirectional
     */
    @ManyToMany(mappedBy = "projects")
    private Collection<Employee> MMEmployees;


}
