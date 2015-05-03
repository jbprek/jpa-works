package org.bagab.entity.relationships.one2many_bi;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "org.bagab.entity.relationships.one2many_bi.Department")
@Table(name = "OMB_DEPARTMENT")
public class Department {

    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    private String name;

    // TODO what to do with lazy fetch type
    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER)
    private Collection<Employee> employees;

    //----------- GET/SET --------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employess) {
        this.employees = employess;
    }

    // ----------- hashCode and equals -------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(employees != null ? !employees.equals(that.employees) : that.employees != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }
}


