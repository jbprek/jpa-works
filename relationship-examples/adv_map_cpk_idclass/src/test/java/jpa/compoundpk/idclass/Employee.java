package jpa.compoundpk.idclass;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author prekezes.
 */

@Table(name = "AREL_CPK_ID_EMPLOYEE")
@Entity
@IdClass(value = EmployeeId.class)
public class Employee implements Serializable {

    @Id
    @Column(name="EMP_ID")
    private long code;
    @Id
    private String county;
    private String name;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (code != employee.code) return false;
        if (county != null ? !county.equals(employee.county) : employee.county != null) return false;
        return !(name != null ? !name.equals(employee.name) : employee.name != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (code ^ (code >>> 32));
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}