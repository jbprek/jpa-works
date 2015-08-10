package basic_relationship.one2one_bi;

import javax.persistence.*;

/**
 * Created by john on 8/8/15.
 */
@Entity
public class Room {
    @GeneratedValue
    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "CUST_ID")
    private Customer customer;


    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
