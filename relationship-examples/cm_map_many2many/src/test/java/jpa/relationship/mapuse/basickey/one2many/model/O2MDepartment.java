package jpa.relationship.mapuse.basickey.one2many.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.*;


@Entity
@Table(name="CMM_BK_O2M_DEPT")
public class O2MDepartment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy="department")
    @MapKeyColumn(name="CUB_ID",nullable = true)
    private Map<String, O2MEmployee> employeesByCubicle;
    
    public O2MDepartment() {
        employeesByCubicle = new HashMap<String, O2MEmployee>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }
    
    public Map<String, O2MEmployee> getEmployees() {
        return employeesByCubicle;
    }

    public void addEmployee(String cubeId, O2MEmployee employee) {
        employeesByCubicle.put(cubeId, employee);
        if (employee.getDepartment() != null) {
            employee.getDepartment().removeEmployee(employee);
        }
        employee.setDepartment(this);
    }

    public void removeEmployee(O2MEmployee employee) {
        Iterator iter = employeesByCubicle.entrySet().iterator();
        while (iter.hasNext()) {
            O2MEmployee current = ((Map.Entry<String,O2MEmployee>) iter.next()).getValue();
            if (current.getId() == employee.getId()) {
                iter.remove();
                current.setDepartment(null);
            }
        }
    }

    public String toString() {
        StringBuffer aBuffer = new StringBuffer("O2MDepartment ");
        aBuffer.append(" id: ");
        aBuffer.append(id);
        aBuffer.append(" name: ");
        aBuffer.append(name);
        aBuffer.append(" employeeCount: ");
        aBuffer.append(employeesByCubicle.size());
        return aBuffer.toString();
    }
}