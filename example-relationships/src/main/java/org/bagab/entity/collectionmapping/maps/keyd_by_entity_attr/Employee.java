package org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
//@Table(name="MOU_EMPLOYEE")
//@Entity(name="org.bagab.entity.collectionmapping.maps.keyd_by_entity_attr.Employee")
//@Table(name="CMMKE_EMPLOYEE")
public class Employee {
//    @Id
    private long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String code;

//    @ManyToOne
//    @JoinColumn(name = "DEPT_ID")
    private Department MOUDepartment;

  // GET SET

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Department getMOUDepartment() {
        return MOUDepartment;
    }

    public void setMOUDepartment(Department MOUDepartment) {
        this.MOUDepartment = MOUDepartment;
    }
}
