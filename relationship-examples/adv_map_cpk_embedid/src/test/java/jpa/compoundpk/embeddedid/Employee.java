package jpa.compoundpk.embeddedid;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author prekezes.
 */

@Table(name = "AREL_CPK_ID_EMPLOYEE")
@Entity
public class Employee implements Serializable {

    @EmbeddedId
    private EmployeeId id;

    private String name;

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
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

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        return !(name != null ? !name.equals(employee.name) : employee.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}