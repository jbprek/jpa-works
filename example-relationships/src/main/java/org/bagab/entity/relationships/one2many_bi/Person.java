package org.bagab.entity.relationships.one2many_bi;

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
    private Collection<Phone> phones;

  // GET SET
}
