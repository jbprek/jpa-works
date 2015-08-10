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

    /* Owner */
    @OneToOne
    //@JoinColumn(name = "CUST_ID")
    private HotelCustomer customer;


    public long getId() {
        return id;
    }

    public HotelCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(HotelCustomer customer) {
        this.customer = customer;
    }
}
