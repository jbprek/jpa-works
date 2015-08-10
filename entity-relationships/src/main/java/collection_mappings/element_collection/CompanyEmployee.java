package collection_mappings.element_collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EC_EMP")
public class CompanyEmployee {
    @Id
    @GeneratedValue
    private long id;

    @ElementCollection
    // defaultEmployee_nicknames
    @CollectionTable(name = "EC_EMP_VAC")
    private List<VacationEntry> vacationEntries = new ArrayList<>();

    @ElementCollection
     //  default  Employee_vacationEntries
    @CollectionTable(name = "EC_EMP_VAC")
    @AttributeOverrides({
            @AttributeOverride(name = "startDate",
                    column = @Column(name = "ST_DT")),
            @AttributeOverride(name = "duration",
                    column = @Column(name = "TOT_DT"))
    })
    private List<String> nicknames = new ArrayList<>();

    public long getId() {
        return id;
    }

    public List<VacationEntry> getVacationEntries() {
        return vacationEntries;
    }

    public void setVacationEntries(List<VacationEntry> vacationEntries) {
        this.vacationEntries = vacationEntries;
    }

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
    }
}
