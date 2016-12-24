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
package org.bagab.orders.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="ORDERS")
@XmlRootElement(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    @XmlTransient
    private Customer customer;

    private String description;

    @ElementCollection
    @CollectionTable(name="ORDER_DETAILS")
    @MapKeyJoinColumn(name="PRODUCT_ID")
    @Column(name="QUANTITY")
    @XmlTransient
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

    public Map<Product, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Product, Integer> quantities) {
        this.quantities = quantities;
    }

    //
//    @GET
//    @Path("products/{productId}/")
//    public Product getProduct(@PathParam("productId")int productId) {
//        System.out.println("----invoking getProduct with id: " + productId);
//        Product p = products.get(new Long(productId));
//        return p;
//    }
//
//    final void init() {
//        Product p = new Product();
//        p.setId(323);
//        p.setDescription("product 323");
//        products.put(p.getId(), p);
//    }
}
