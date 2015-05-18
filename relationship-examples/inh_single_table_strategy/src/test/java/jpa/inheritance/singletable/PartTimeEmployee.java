package jpa.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author prekezes.
 */
@Entity
@DiscriminatorValue("PT_EMP")
public class PartTimeEmployee extends CompanyEmployee{
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
