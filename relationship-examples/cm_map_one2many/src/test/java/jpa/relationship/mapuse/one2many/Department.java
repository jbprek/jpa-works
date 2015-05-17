package jpa.relationship.mapuse.one2many;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prekezes.
 */
@Table(name="CM_OMB_DEPARTMENT")
@Entity
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy="department")
    @MapKeyColumn(name="CUB_ID", nullable = true)
    private Map<String, Employee> employeesByCubicle = new HashMap<>();

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

    public Map<String, Employee> getEmployeesByCubicle() {
        return employeesByCubicle;
    }

    public void setEmployeesByCubicle(Map<String, Employee> employeesByCubicle) {
        this.employeesByCubicle = employeesByCubicle;
    }
}
