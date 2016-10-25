package jpa.basicmapping.m2mb;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "BANK_ACCOUNT_OWNER")
@Entity
public class BankAccountOwner {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BANK_ACCOUNT_OWNER_BANK_ACCOUNT", joinColumns = @JoinColumn(name="BANK_ACCOUNT_OWNER_ID"), inverseJoinColumns = @JoinColumn(name="BANK_ACCOUNT_ID"))
    private Set<BankAccount> bankAccounts = new HashSet<>();

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

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
