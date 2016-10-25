package jpa.basicmapping.o2mu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author prekezes.
 */

@Table(name="TELCO_CUSTOMER")
@Entity
public class TelcoCustomer {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    // optional attribute default=true
    @OneToMany
    @JoinTable(name = "TELCO_CUSTOMER_PHONE",
            joinColumns = @JoinColumn(name = "TELCO_CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PHONE_ID"))
    private Collection<Phone> phones = new ArrayList<>();

    public long getId() {
        return id;
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
