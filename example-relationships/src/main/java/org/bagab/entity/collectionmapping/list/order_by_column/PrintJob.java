package org.bagab.entity.collectionmapping.list.order_by_column;

import javax.persistence.*;

/**
 * Created by x on 5/1/15.
 */
@Entity
public class PrintJob {
    @Id @GeneratedValue
    private long id;

    private String payload;

    @Column(name = "PRINT_ORDER")
    private int printOrder;

    @ManyToOne
    private PrintQueue printQueue;

    // GET SET
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }

    public PrintQueue getPrintQueue() {
        return printQueue;
    }

    public void setPrintQueue(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }
}
