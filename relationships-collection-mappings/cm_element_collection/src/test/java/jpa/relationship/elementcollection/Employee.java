package jpa.relationship.elementcollection;

import javax.persistence.*;
import java.util.*;

/**
 * @author prekezes.
 */

@Table(name = "CM_EC_EMPLOYEE")
@Entity
public class Employee {
    @GeneratedValue
    @Id
    private long id;

    @Basic//(optional = false)
    //@Column(nullable = false, unique = true)
    private String name;

    @ElementCollection//(fetch = FetchType.EAGER /*, targetClass=VacationEntry.class*/)
    @CollectionTable(name="CM_EC_EMP_VACATION",
                     joinColumns = @JoinColumn(name="EMP_ID"))
    @AttributeOverrides({
            @AttributeOverride(name="startDate", column=@Column(name = "ST_DT")),
            @AttributeOverride(name="duration", column=@Column(name = "NUM"))
        })
//    @OrderBy("ST_DT")
    private List<VacationEntry> vacationEntries  = new ArrayList<>();
    /* NOTE Without vacationEntries construction getVacationEntries() returns null */

    @ElementCollection//(fetch = FetchType.EAGER)
    @CollectionTable(name = "CM_EC_EMP_NNAMES", joinColumns = @JoinColumn(name = "EMP_ID"))
//    @OrderColumn
    private List<String> nickNames = new ArrayList<>();

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

    public List<VacationEntry> getVacationEntries() {
        return vacationEntries;
    }

    public void setVacationEntries(List<VacationEntry> vacationEntries) {
        this.vacationEntries = vacationEntries;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }
}
