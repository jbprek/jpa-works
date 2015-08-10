package basic_relationship.many2many_si;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author prekezes.
 */
@Entity
public class Task {
    @GeneratedValue
    @Id
    private long id;

    private String name;
    /* Owner */
    @ManyToMany
    @JoinTable(name="TASK_TEAM", joinColumns = {@JoinColumn(name="TASK_ID")}, inverseJoinColumns = {@JoinColumn(name="TEAM_ID")})
    private Set<Team> teams = new HashSet<>();

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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
