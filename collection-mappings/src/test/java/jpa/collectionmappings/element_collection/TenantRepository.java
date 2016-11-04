package jpa.collectionmappings.element_collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface TenantRepository extends Repository<Tenant, Long> {

//
//    @Query("SELECT t.reservations from Tenant t WHERE t = ?")
//    Stream<Reservation> findReservations(Tenant t);


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<Tenant> findOne(Long id);

    /**
     * Saves the given {@link Tenant}.
     *
     * @param Tenant
     * @return
     */
    <S extends Tenant> S save(S Tenant);

    /**
     * Sample method to derive a query from using JDK 8's {@link Optional} as return type.
     *
     * @param name
     * @return
     */
    Optional<Tenant> findByName(String name);

    /**
     * Sample method to demonstrate support for {@link Stream} as a return type with a custom query. The query is executed
     * in a streaming fashion which means that the method returns as soon as the first results are ready.
     *
     * @return
     */
    @Query("select c from Tenant c")
    Stream<Tenant> streamAllTenants();





}
