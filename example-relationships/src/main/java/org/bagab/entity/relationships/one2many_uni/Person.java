package org.bagab.entity.relationships.one2many_uni;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
@Table(name="OMU_PERSON")
public class Person {
    @Id  @GeneratedValue
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="OMU_PERSON_PHONE",
            joinColumns=@JoinColumn(name="EMP_ID"),
            inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
    private Collection<Phone> phones;

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

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }
}
