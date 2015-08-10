package basic_relationship.one2one_bi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by john on 8/8/15.
 */
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private long id;

    private String name;
    /* the mappedBy is necessary, otherwise to One2One relationships will be created */
    @OneToOne(mappedBy="customer")
    private Room room;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
