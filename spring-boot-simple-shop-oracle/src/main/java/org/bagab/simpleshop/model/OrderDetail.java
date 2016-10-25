package org.bagab.simpleshop.model;

/**
 * Created by john_000 on 10/23/2016.
 */

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetail {

    private int quantity;
}
