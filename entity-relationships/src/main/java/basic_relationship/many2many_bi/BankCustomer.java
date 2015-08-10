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
public class BankCustomer {

    @GeneratedValue
    @Id
    private long id;

    private String name;
    /* Owner */
    @ManyToMany
//    @JoinTable( joinColumns = {@JoinColumn(name="TASK_ID")}, inverseJoinColumns = {@JoinColumn(name="TEAM_ID")})
    private Set<BankAccount> accounts = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<BankAccount> accounts) {
        this.accounts = accounts;
    }
}
