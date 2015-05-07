package org.bagab.entity.collectionmapping.element_collection;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author prekezes.
 */
@Entity(name="org.bagab.entity.collectionmapping.element_collection.Employee")
@Table(name="EC_EMPLOYEE")
public class Employee {
    @Id
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "EC_NICKNAMES",
            joinColumns = @JoinColumn(name = "EMP_ID"))
    private Collection<String> nicknames;

    @ElementCollection// (targetClass = VacationEntry.class)
    /* Optional*/
    @CollectionTable(
            name = "EC_VACATION_ENTRY",
            joinColumns = @JoinColumn(name = "EMP_ID"))
    /* Optional */
    @AttributeOverride(name = "duration",
            column = @Column(name = "DAYS_ABS"))
    private Collection<VacationEntry> absenceDays;

    /*---------- GET SET --------------------*/

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

    //------- Hash Code and Equals ---------------/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
