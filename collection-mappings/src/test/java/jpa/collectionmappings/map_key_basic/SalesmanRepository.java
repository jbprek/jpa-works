package jpa.collectionmappings.map_key_basic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;


public interface SalesmanRepository extends Repository<Salesman, Long> {


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<Salesman> findOne(Long id);

    /**
     * Saves the given {@link Salesman}.
     *
     * @param Salesman
     * @return
     */
    <S extends Salesman> S save(S Salesman);




}
