package org.bagab.mini_jpa;

import javax.persistence.*;

/**
 * Created by u on 4/12/15.
 */
@Entity
@Table(name = "MINIJPA_CAR")
public class Car {

    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO) this is the default
    private long id;

    private String name;

    /**
     * No need for setter
     * @return
     */
    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
