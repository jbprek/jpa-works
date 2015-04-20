package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Table(name="ONE_TO_MANY_UNI_EMPLOYEE")
@Entity
public class Employee {
    @Id
    private long id;

    @OneToMany
    @JoinTable(name = "ONE_TO_MANY_UNI_EMP_PHONE",joinColumns = @JoinColumn(name="EMP_ID"), inverseJoinColumns = @JoinColumn(name="PHONE_ID"))
    private List<Phone> phone;

}
