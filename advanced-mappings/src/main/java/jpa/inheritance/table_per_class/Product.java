package jpa.inheritance.table_per_class;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_000 on 11/6/2016.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<Part> parts = new ArrayList<>();


}
