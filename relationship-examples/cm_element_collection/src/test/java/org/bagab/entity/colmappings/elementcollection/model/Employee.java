package org.bagab.entity.colmappings.elementcollection.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name = "CM_EC_EMPLOYEE")
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic//(optional = false)
    //@Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "CM_EC_EMP_NNAMES", joinColumns = @JoinColumn(name = "EMP_ID"))
//    @AttributeOverrides({@AttributeOverride(name = "startDate", column = @Column(name = "ST_DT")),
//            @AttributeOverride(name = "duration", column = @Column(name = "NUM"))})
    private List<VacationEntry> vacationEntries = new ArrayList<>();
    /* NOTE Without vacationEntries construction getVacationEntries() returns null */

    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "CM_EC_EMP_NNAMES")
    private List<String> nickNames;

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

    public List<VacationEntry> getVacationEntries() {
        return vacationEntries;
    }

    public void setVacationEntries(List<VacationEntry> vacationEntries) {
        this.vacationEntries = vacationEntries;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }
}
