package org.bagab.entity.colmappings.elementcollection.model;

import javax.persistence.*;
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

    @ElementCollection(fetch = FetchType.EAGER, targetClass=VacationEntry.class)
    @CollectionTable(name = "CM_EC_EMP_VACATION", joinColumns = @JoinColumn(name = "EMP_ID"))
    @AttributeOverrides({@AttributeOverride(name = "startDate", column = @Column(name = "ST_DT")),
            @AttributeOverride(name = "duration", column = @Column(name = "NUM"))})
    @OrderColumn

    private Collection vacationEntries;// = new ArrayList<>();
    /* NOTE Without vacationEntries construction getVacationEntries() returns null */

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "CM_EC_EMP_NNAMES", joinColumns = @JoinColumn(name = "EMP_ID"))
//    @OrderColumn
//    private Collection<String> nickNames;

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

    public Collection<VacationEntry> getVacationEntries() {
        return vacationEntries;
    }

    public void setVacationEntries(List<VacationEntry> vacationEntries) {
        this.vacationEntries = vacationEntries;
    }

//    public Collection<String> getNickNames() {
//        return nickNames;
//    }
//
//    public void setNickNames(List<String> nickNames) {
//        this.nickNames = nickNames;
//    }
}
