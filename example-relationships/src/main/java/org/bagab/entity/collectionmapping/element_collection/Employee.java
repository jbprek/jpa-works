package org.bagab.entity.collectionmapping.element_collection;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
//@Table(name="CMP_EMPLOYEE")
public class Employee {
    @Id
    private long id;

    private String name;

    @ElementCollection
    private Collection<String> nicknames;

    @ElementCollection(targetClass = VacationEntry.class)
    /* Optional*/
    @CollectionTable(
            name = "VACATION",
            joinColumns = @JoinColumn(name = "EMP_ID"))
    /* Optional */
    @AttributeOverride(name = "daysTaken",
            column = @Column(name = "DAYS_ABS"))
    private Collection absenceDays;
    /* The above could be defined as Collection<VacationEntry> eliminating the need for targetClass in @ElementCollection */


}
