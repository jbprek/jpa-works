package org.bagab.entity.collectionmapping.element_collection;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity(name="org.bagab.entity.collectionmapping.element_collection.Employee")
@Table(name="EC_EMPLOYEE")
public class Employee {
    @Id
    private long id;

    private String name;

    @ElementCollection
    private Collection<String> nicknames;

    @ElementCollection//(targetClass = VacationEntry.class)
    /* Optional*/
    @CollectionTable(
            name = "EC_EMPLOYEE_VACATION_ENTRY",
            joinColumns = @JoinColumn(name = "EMP_ID"))
    /* Optional */
    @AttributeOverride(name = "daysTaken",
            column = @Column(name = "DAYS_ABS"))
    private Collection<VacationEntry> absenceDays;

    @ElementCollection
    @CollectionTable(name="EC_EMPLOYEE_NICK_NAME")
    private Collection<String> nickNames;

    //------------ Get Set ------------

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

    public Collection<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(Collection<String> nicknames) {
        this.nicknames = nicknames;
    }

    public Collection<VacationEntry> getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(Collection<VacationEntry> absenceDays) {
        this.absenceDays = absenceDays;
    }

    public Collection<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Collection<String> nickNames) {
        this.nickNames = nickNames;
    }
}
