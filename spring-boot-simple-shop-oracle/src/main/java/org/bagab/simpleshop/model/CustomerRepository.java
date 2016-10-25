package org.bagab.simpleshop.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by john_000 on 10/22/2016.
 */
@Repository
@Transactional
public interface CustomerRepository  extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String Name);
}
