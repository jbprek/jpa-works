package org.bagab.projpa.collectionmapping.physical;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
@Table(name="CMP_EMPLOYEE")
public class CMP_Employee {
    @Id private long id;

    private String name;

    @ElementCollection
    private Collection<String> nicknames;

    @ElementCollection(targetClass=CMP_VacationEntry.class)
    @CollectionTable(
            name="VACATION",
            joinColumns=@JoinColumn(name="EMP_ID"))
    @AttributeOverride(name="daysTaken",
            column=@Column(name="DAYS_ABS"))
    private Collection absenceDays;

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

    public Collection getAbsenceDays() {
        return absenceDays;
    }

    public void setAbsenceDays(Collection absenceDays) {
        this.absenceDays = absenceDays;
    }

    @Override
    public String toString() {
        return "CMP_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nicknames=" + nicknames +
                ", absenceDays=" + absenceDays +
                '}';
    }
}
