package jpa.inheritance.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author prekezes.
 */
@Entity
@DiscriminatorValue("2")
public class FullTimeEmployee extends CompanyEmployee {
    private int salary;
    private int pension;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }
}
