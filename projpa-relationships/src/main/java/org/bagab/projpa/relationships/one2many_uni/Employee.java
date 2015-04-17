package org.bagab.projpa.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Table(name="ONE_TO_MANY_UNI_EMPLOYEE")
@Entity
public class Employee {
    @Id
    private long id;

    @OneToMany
    @JoinTable(name = "ONE_TO_MANY_UNI_EMP_PHONE",joinColumns = @JoinColumn(name="EMP_ID"), inverseJoinColumns = @JoinColumn(name="PHONE_ID"))
    private Phone phone;

    public long getId() {
        return id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(phone, employee.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }
}
