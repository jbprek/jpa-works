package basic_relationship.one2many_si;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Student {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    @OneToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name="PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name="PRESENTATION_ID")})
    private Collection<Presentation> presentations = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Collection<Presentation> presentations) {
        this.presentations = presentations;
    }
}
