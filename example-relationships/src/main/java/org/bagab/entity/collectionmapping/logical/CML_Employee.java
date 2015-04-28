package org.bagab.entity.collectionmapping.logical;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
@Table(name="CML_EMPLOYEE")
public class CML_Employee {
    @Id private long id;

    private String name;

    @ElementCollection
    private Collection<String> nicknames;

    @ElementCollection
    private Collection<CML_VacationEntry> vacationEntries;

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

    public Collection<CML_VacationEntry> getVacationEntries() {
        return vacationEntries;
    }

    public void setVacationEntries(Collection<CML_VacationEntry> vacationEntries) {
        this.vacationEntries = vacationEntries;
    }

    @Override
    public String toString() {
        return "CML_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nicknames=" + nicknames +
                ", vacationEntries=" + vacationEntries +
                '}';
    }
}
