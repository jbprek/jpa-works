package jpa.inheritance.singletable;

import javax.persistence.MappedSuperclass;

/**
 * @author prekezes.
 */
@MappedSuperclass
public abstract class CompanyEmployee extends Employee{
    private int vacationDays;

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}
