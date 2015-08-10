package basic_relationship.many2one;

import javax.persistence.*;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Soldier {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
