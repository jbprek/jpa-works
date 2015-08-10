package basic_relationship.one2many_si;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Presentation {
    @GeneratedValue
    @Id
    private long id;

    private String title;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
