package org.bagab.entity.relationships.listorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="CML_PRINT_ITEM")
public class PrintItem {
    @Id  @GeneratedValue
    private long id;

    @ManyToOne
    private PrintQueue queue;

    @OrderColumn(name="PRINT_ORDER")
    private long printOrder;

    private String job;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PrintQueue getQueue() {
        return queue;
    }

    public void setQueue(PrintQueue queue) {
        this.queue = queue;
    }

    public long getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(long printOrder) {
        this.printOrder = printOrder;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
