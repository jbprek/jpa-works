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
    private String name;

    @OneToMany
    @OrderColumn(name="PRINT_ORDER")
    private List<PrintJob> jobs;

    // GET SET

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrintJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<PrintJob> jobs) {
        this.jobs = jobs;
    }
}
