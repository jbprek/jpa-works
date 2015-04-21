package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
@Table(name="OMU_PERSON")
public class OMU_Person {
    @Id
    private long id;
    private String name;
    @OneToMany
    @JoinTable(name="OMU_PERSON_PHONE",
            joinColumns=@JoinColumn(name="EMP_ID"),
            inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
    private Collection<OMU_Phone> phones;

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

    public Collection<OMU_Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<OMU_Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "OMU_Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
