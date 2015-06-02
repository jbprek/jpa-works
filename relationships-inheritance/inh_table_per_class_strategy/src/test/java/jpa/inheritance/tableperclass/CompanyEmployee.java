package jpa.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author prekezes.
 */
@MappedSuperclass
public abstract class CompanyEmployee extends Employee{
    private int vacationDays;

    @ManyToOne
    private Employee manager;

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
