package org.bagab.entity.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;

/**
 * Created by x on 4/25/15.
 */
//@Table(name="OMU_PHONE")
@Entity
public class Phone {

    @Id
    private long id;

    private String number;


    // GET SET
}
