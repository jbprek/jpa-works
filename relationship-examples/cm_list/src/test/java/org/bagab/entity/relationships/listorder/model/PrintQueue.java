package org.bagab.entity.relationships.listorder.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "CML_PRINT_QUEUE")
public class PrintQueue {
    @Id private String name;

    @OneToMany(mappedBy="queue")
    @OrderColumn(name="PRINT_ORDER")
    private List<PrintJob> jobs;
    
    public PrintQueue() {
        jobs = new ArrayList<PrintJob>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrintJob> getJobs() {
        return jobs;
    }

    public void addJob(PrintJob job) {
        this.jobs.add(job);
        job.setQueue(this);
    }
    
    public String toString() {
        return "PrintQueue: " + name;
    }
}
