package org.bagab.entity.relationships.one2many_bi;


import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity(name = "org.bagab.entity.relationships.one2many_bi.Employee")
@Table(name="OMB_EMPLOYEE")
public class Employee {

    @GeneratedValue
    @Id
    private long id;

    @Basic(optional=false)
    private String name;

    @ManyToOne//(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "DEPT_ID")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // ----------- hashCode and equals -------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return !(department != null ? !department.equals(employee.department) : employee.department != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
