package jpa.inheritance.tableperclass;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Table(name="CONTRACT_EMP")
@Entity
@AttributeOverrides({
        @AttributeOverride(name="name",column=@Column(name="FULLNAME")),
        @AttributeOverride(name="startDate",column=@Column(name="SDATE"))
})
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
