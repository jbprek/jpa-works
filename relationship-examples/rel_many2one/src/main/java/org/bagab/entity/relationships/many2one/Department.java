package org.bagab.entity.relationships.many2one;

import javax.persistence.*;

/**
 * Single value association, for bidirectional ManyToOne see bidirectional OneToMany which is a collection based association
 */
@Entity
@Table(name = "MOU_DEPARTMENT")
public class Department {

    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    //----------- GET/SET --------------------------

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
