package org.bagab.entity.relationships.one2many_bi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by x on 4/25/15.
 */
//@Table(name="OMU_PHONE")
@Entity
public class Phone {

    @Id
    private long id;

    private String number;
    //    @JoinTable(name="OMU_PERSON_PHONE",
//            joinColumns=@JoinColumn(name="EMP_ID"),
//            inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
    @ManyToOne
    private Person person;
    // GET SET
}
