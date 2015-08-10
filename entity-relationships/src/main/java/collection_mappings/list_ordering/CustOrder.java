package collection_mappings.list_ordering;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.*;

/**
 * @author prekezes.
 */
@Entity
public class CustOrder {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy = "order")
    @OrderBy("name DESC") //   alternative ("name DESC")
    private List<OrderItem> items = new ArrayList<>();

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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> employees) {
        this.items = employees;
    }
}
