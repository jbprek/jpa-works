package org.bagab.orders.model;

import org.bagab.orders.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by john_000 on 10/22/2016.
 */
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    /**
     * Find the user with the given username. This method will be translated into a query using the
     * {@link javax.persistence.NamedQuery} annotation at the {@link Customer} class.
     *
     * @param username
     * @return
     */
    Customer findByTheUsername(String username);

    /**
     * Uses {@link Optional} as return and parameter type.
     *
     * @param username
     * @return
     */
    Optional<Customer> findByUsername(Optional<String> username);

    /**
     * Find all users with the given lastname. This method will be translated into a query by constructing it directly
     * from the method name as there is no other query declared.
     *
     * @param lastname
     * @return
     */
    List<Customer> findByLastname(String lastname);

    /**
     * Returns all users with the given firstname. This method will be translated into a query using the one declared in
     * the {@link Query} annotation declared one.
     *
     * @param firstname
     * @return
     */
    @Query("select u from Customer u where u.firstname = :firstname")
    List<Customer> findByFirstname(String firstname);

    /**
     * Returns all users with the given name as first- or lastname. This makes the query to method relation much more
     * refactoring-safe as the order of the method parameters is completely irrelevant.
     *
     * @param name
     * @return
     */
    @Query("select u from Customer u where u.firstname = :name or u.lastname = :name")
    List<Customer> findByFirstnameOrLastname(@Param("name") String name);

    /**
     * Returns the total number of entries deleted as their lastnames match the given one.
     *
     * @param lastname
     * @return
     */
    Long removeByLastname(String lastname);

    /**
     * Returns a {@link Slice} counting a maximum number of {@link Pageable#getPageSize()} users matching given criteria
     * starting at {@link Pageable#getOffset()} without prior count of the total number of elements available.
     *
     * @param lastname
     * @param page
     * @return
     */
    Slice<Customer> findByLastnameOrderByUsernameAsc(String lastname, Pageable page);

    /**
     * Return the first 2 users ordered by their lastname asc.
     *
     * <pre>
     * Example for findFirstK / findTopK functionality.
     * </pre>
     *
     * @return
     */
    List<Customer> findFirst2ByOrderByLastnameAsc();

    /**
     * Return the first 2 users ordered by the given {@code sort} definition.
     *
     * <pre>
     * This variant is very flexible because one can ask for the first K results when a ASC ordering
     * is used as well as for the last K results when a DESC ordering is used.
     * </pre>
     *
     * @param sort
     * @return
     */
    List<Customer> findTop2By(Sort sort);

    /**
     * Return all the users with the given firstname or lastname. Makes use of SpEL (Spring Expression Language).
     *
     * @param customer
     * @return
     */
    @Query("select u from Customer u where u.firstname = :#{#customer.firstname} or u.lastname = :#{#customer.lastname}")
    Iterable<Customer> findByFirstnameOrLastname(@Param("customer") Customer customer);}
