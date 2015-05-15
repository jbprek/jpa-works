package org.bagab.entity.relationships.listorder.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name="CML_PRINT_QUEUE")
public class PrintQueue {

    private final AtomicLong printOrderSequence = new AtomicLong(0);

    @Id
    private String name;

    @OneToMany(mappedBy="queue", fetch = FetchType.EAGER)
    @OrderColumn(name="PRINT_ORDER")
    private List<PrintItem> jobs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrintItem> getJobs() {
        return jobs;
    }

    public void setJobs(List<PrintItem> jobs) {
        this.jobs = jobs;
    }

    public long nextPrintOrderValue() {
        return printOrderSequence.incrementAndGet();
    }
}
