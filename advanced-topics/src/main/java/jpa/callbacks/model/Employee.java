package jpa.callbacks.model;

import javax.persistence.*;

/**
 * @author prekezes.
 */

@Table(name = "ATCB_EMPLOYEE")
@Entity
@EntityListeners(EmployeeEntityListener.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    private String name;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
