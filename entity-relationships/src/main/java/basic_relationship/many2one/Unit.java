package basic_relationship.many2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Unit {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
