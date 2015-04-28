package org.bagab.entity.relationships.many2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

/**
 * @author prekezes.
 */
//@Table(name = "MM_EMP")
@Entity
public class Employee {
    @Id
    private long id;

    private String name;

    @ManyToMany
//    @JoinTable(name = "MM_EMP_PROJ", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID"))
    private Collection<Project> projects;


    /*---------- GET SET --------------------*/


}
