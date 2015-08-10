package basic_relationship.many2many_bi;

import basic_relationship.many2many_si.Team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BankAccount {
    @GeneratedValue
    @Id
    private long id;

    private String name;
    @ManyToMany(mappedBy="accounts")
    private Set<BankCustomer> customers = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BankCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<BankCustomer> customers) {
        this.customers = customers;
    }
}
