package org.bagab.entity.relationships.many2one.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="M2O_DEPARTMENT")
public class Department {

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
}
