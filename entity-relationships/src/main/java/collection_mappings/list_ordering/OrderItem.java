package collection_mappings.list_ordering;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
public class OrderItem implements Comparable{
    @Id
    @GeneratedValue
    private long id;

    @Basic(optional = false)
    private String code;

    @ManyToOne
    private CustOrder order;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustOrder getOrder() {
        return order;
    }

    public void setOrder(CustOrder department) {
        this.order = department;
    }

    @Override
    public int compareTo(Object o) {
        OrderItem other = (OrderItem) o;
        return code.compareTo(other.getCode());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + code + '\'' +
                ", order_by=" + order.getName() +
                '}';
    }
}



