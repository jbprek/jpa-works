package jpa.inheritance.tableperclass;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Table(name="ITPC_PRTTIME_EMP")
@Entity
@AttributeOverride(name="manager", column=@Column(name="MGR"))
public class PartTimeEmployee extends CompanyEmployee{
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
