package jpa.basicmapping.m2o;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name = "SCHOOL_STUDENT")
public class SchoolStudent {

    @Id
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "CLASS_ID")
    private SchoolClass schoolClass;

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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}



