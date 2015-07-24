package jpa.inheritance.tableperclass;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Table(name="ITPC_FULTIME_EMP")
@Entity
@AssociationOverride(name="department",joinColumns = @JoinColumn(name="DPT"))
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
