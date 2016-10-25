package jpa.basicmapping.m2mu;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author prekezes.
 */
@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TRACK_TRANSPORT",
                    joinColumns = @JoinColumn(name="TRACK_ID"),
            inverseJoinColumns = @JoinColumn(name="TRANSPORT_ID"))
    private Set<Transport> transports = new HashSet<>();

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

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

}
