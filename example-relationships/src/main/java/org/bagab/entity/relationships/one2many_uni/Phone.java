package org.bagab.entity.relationships.one2many_uni;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by x on 4/25/15.
 */
@Table(name="OMU_PHONE")
@Entity
public class Phone {

    @Id @GeneratedValue
    private long id;

    private String number;


    // GET SET


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
