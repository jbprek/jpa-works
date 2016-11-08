package jpa.inheritance.table_per_class;

import javax.persistence.*;

/**
 * Created by john_000 on 11/6/2016.
 */

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Product product;
}
