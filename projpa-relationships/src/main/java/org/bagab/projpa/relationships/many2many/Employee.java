package org.bagab.projpa.relationships.many2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Table(name = "MANY_TO_MANY_EMP")
@Entity
public class Employee {
    @Id
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "MANY_TO_MANY_EMP_PROJ", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
    private Collection<Project> projects;


}
