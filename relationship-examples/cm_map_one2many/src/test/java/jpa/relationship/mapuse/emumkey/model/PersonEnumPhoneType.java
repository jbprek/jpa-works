package jpa.relationship.mapuse.emumkey.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="CMM_BK_ENUM_KEY_PERSON")
public class PersonEnumPhoneType {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    @ElementCollection
    @CollectionTable(name = "CMM_BK_ENUM_KEY_EMP_PHONE")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "PHONE_NUM")
    private Map<PhoneType, String> phoneNumbers = new HashMap<>();

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "PersonS{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}