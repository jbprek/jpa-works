package org.bagab.entity.collectionmapping.list.order_by_column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.List;

/**
 * Created by x on 5/1/15.
 */
@Entity
public class PrintQueue {
    @Id
    private long id;

    private String name;

    @OneToMany
    @OrderColumn(name="PRINT_ORDER")
    private List<PrintJob> jobs;
}
