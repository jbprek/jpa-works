package jpa.inheritance.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author prekezes.
 */
@Entity
@Table(name="IJS_CONTRACT_EMPLOYEE")
@DiscriminatorValue("1")
public class ContractEmployee extends Employee {
    private int dailyRate;
    private int term;

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
