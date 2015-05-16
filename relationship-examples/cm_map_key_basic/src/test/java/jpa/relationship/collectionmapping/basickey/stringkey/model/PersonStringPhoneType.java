package jpa.relationship.collectionmapping.basickey.stringkey.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="CMM_BK_STR_KEY_PERSON")
public class PersonStringPhoneType {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;

    @ElementCollection
    @CollectionTable(name = "CMM_BK_STR_KEY_PERSON_PHONE")
    @MapKeyColumn(name = "PHONE_TYPE")
    @Column(name = "PHONE_NUM")
    private Map<String, String> phoneNumbers = new HashMap<>();

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
    
    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "PersonStringPhoneType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}