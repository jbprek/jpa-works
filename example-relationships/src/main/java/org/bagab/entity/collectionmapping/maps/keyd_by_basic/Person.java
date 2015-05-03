package org.bagab.entity.collectionmapping.maps.keyd_by_basic;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by x on 5/1/15.
 */
@Entity
public class Person {

    @Id
    private long id;

    private String name;


    @ElementCollection
    @CollectionTable(name="EMP_PHONE")
    @MapKeyColumn(name="PHONE_TYPE")
    @Column(name = "PHONE_NUM")
    private Map<String,String> phones;
}
