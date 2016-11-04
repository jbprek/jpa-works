package jpa.collectionmappings.order_column;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by john_000 on 11/4/2016.
 */
@Entity
public class PrintJob {

    @GeneratedValue
    @Id
    private long id;

    private String payload;

    @ManyToOne
    @JoinColumn(name="PRINTER_ID")
    private Printer printer;


    public PrintJob() {
    }


    public PrintJob( Printer printer, String payload) {
        this.payload = payload;
        this.printer = printer;
    }

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

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrintJob{");
        sb.append("id=").append(id);
        sb.append(", payload='").append(payload).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
