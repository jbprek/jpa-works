package org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import java.util.Map;

/**
 * Single value association
 */
@Entity
//@Table(name="MOU_DEPARTMENT")
public class Department {

    @Id
    private long id;

    private String name;

    @OneToMany
    @MapKey(name = "code")
    Map<String, Employee> employees;


}
