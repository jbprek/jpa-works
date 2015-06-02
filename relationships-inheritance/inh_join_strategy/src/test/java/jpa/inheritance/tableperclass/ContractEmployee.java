package jpa.inheritance.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author prekezes.
 */
@Entity
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
