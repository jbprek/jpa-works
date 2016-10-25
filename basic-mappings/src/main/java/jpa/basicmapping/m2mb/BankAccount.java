package jpa.basicmapping.m2mb;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "BANK_ACCOUNT")
@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy = "bankAccounts", fetch = FetchType.EAGER)
    private Set<BankAccountOwner> accountOwners = new HashSet<>();

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

    public Set<BankAccountOwner> getAccountOwners() {
        return accountOwners;
    }

    public void setAccountOwners(Set<BankAccountOwner> accountOwners) {
        this.accountOwners = accountOwners;
    }
}
