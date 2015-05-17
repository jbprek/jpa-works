package jpa.relationship.listorder.model;

import javax.persistence.*;

@Entity
@Table(name = "CML_PRINT_ITEM")
public class PrintJob {
    @Id @GeneratedValue private int id;

    @ManyToOne
    private PrintQueue queue;

    private String payload;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrintQueue getQueue() {
        return queue;
    }

    public void setQueue(PrintQueue queue) {
        this.queue = queue;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}