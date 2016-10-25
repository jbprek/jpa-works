/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.bagab.simpleshop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="ORDERS")
public class Order {
    @SequenceGenerator(name="OrdersGen", sequenceName = "ORDERS_ID_SEQ")
    @GeneratedValue(generator = "OrdersGen")
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID", foreignKey = @ForeignKey(name="FK_ORDERS_CUSTOMER_ID"))
    private Customer customer;

    private String description;

    @ElementCollection
    @CollectionTable(name="ORDER_DETAILS")
    @MapKeyJoinColumn(name="PRODUCT_ID", foreignKey =  @ForeignKey(name="ORDER_DETAILS_PRODUCT_ID"))
    @Column(name="QUANTITY")
    private Map<Product, Integer> quantities  = new HashMap<>();

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Map<Product, Integer> getQuantities() {
//        return quantities;
//    }
//
//    public void setQuantities(Map<Product, Integer> quantities) {
//        this.quantities = quantities;
//    }


}
