package org.bagab.entity.relationships.one2many_uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * @author prekezes.
 */
@Entity
//@Table(name="OMU_PERSON")
public class Person {
    @Id
    private long id;
    private String name;
    @OneToMany
//    @JoinTable(name="OMU_PERSON_PHONE",
//            joinColumns=@JoinColumn(name="EMP_ID"),
//            inverseJoinColumns=@JoinColumn(name="PHONE_ID"))
    private Collection<Phone> phones;

  // GET SET
}
