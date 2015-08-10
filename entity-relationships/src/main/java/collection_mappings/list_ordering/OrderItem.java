package collection_mappings.list_ordering;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author prekezes.
 */
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private CustOrder order;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustOrder getOrder() {
        return order;
    }

    public void setOrder(CustOrder department) {
        this.order = department;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order.getName() +
                '}';
    }
}



