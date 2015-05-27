package jpa.callbacks.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author prekezes.
 */

@Table(name = "ATCB_EMPLOYEE")
@Entity
public class Employee {
    @SequenceGenerator(name = "someEntityIdSeq", sequenceName = "ATCB_EMPLOYEE_ID_SEQ")
    @Id
    @GeneratedValue(generator = "someEntityIdSeq")
    private long id;

    @Basic(optional = false)
    private String name;

    //----------- GET/SET --------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
