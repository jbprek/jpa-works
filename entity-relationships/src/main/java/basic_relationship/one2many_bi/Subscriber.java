package basic_relationship.one2many_bi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by john on 8/9/15.
 */
@Entity
public class Subscriber {
    @GeneratedValue
    @Id
    private long id;

    private String name;




}
