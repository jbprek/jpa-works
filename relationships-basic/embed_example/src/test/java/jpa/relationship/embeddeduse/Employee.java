package jpa.relationship.embeddeduse;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author prekezes.
 */

@Table(name = "EMPLOYEE")
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name= "country", column = @Column(name="CNTRY")),
            @AttributeOverride(name= "zip", column = @Column(name="ZIP")),
    })
    private Address address;

    public Employee() {
    }

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
