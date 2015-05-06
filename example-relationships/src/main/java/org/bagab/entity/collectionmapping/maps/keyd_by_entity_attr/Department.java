package org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

/**
 * Single value association
 */
//@Entity(name="org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr.Department")
//@Table(name="CMMKE_DEPARTMENT")
public class Department {

//    @Id
    private long id;

    private String name;

//    @OneToMany
//    @MapKey(name = "code")
    Map<String, Employee> employees;


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

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }
}
