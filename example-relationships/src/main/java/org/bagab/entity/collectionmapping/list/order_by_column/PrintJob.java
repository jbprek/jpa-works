package org.bagab.entity.collectionmapping.list.order_by_column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by x on 5/1/15.
 */
@Entity
public class PrintJob {
    @Id
    private long id;

    private String payload;

    @Column(name = "PRINT_ORDER")
    private int printOrder;

    @ManyToOne
    private PrintQueue printQueue;

    // GET SET
}
