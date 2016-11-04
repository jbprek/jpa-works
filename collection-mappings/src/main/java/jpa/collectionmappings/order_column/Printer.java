package jpa.collectionmappings.order_column;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_000 on 11/4/2016.
 */
@Entity
public class Printer {

    @GeneratedValue
    @Id
    private long id;

    @OneToMany(mappedBy = "printer")
    @OrderColumn(name= "PRINT_ORDER")
    private List<PrintJob> printJobs = new ArrayList<>();


    public Printer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PrintJob> getPrintJobs() {
        return printJobs;
    }

    public void setPrintJobs(List<PrintJob> printJobs) {
        this.printJobs = printJobs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Printer{");
        sb.append("id=").append(id);
        sb.append(", printJobs=").append(getPrintJobs());
        sb.append('}');
        return sb.toString();
    }
}
