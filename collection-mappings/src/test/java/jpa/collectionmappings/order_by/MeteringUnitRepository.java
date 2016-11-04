package jpa.collectionmappings.order_by;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.stream.Stream;


public interface MeteringUnitRepository extends Repository<MeteringUnit, Long> {


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<MeteringUnit> findOne(Long id);

    /**
     * Saves the given {@link MeteringUnit}.
     *
     * @param MeteringUnit
     * @return
     */
    <S extends MeteringUnit> S save(S MeteringUnit);



    /**
     * Sample method to demonstrate support for {@link Stream} as a return type with a custom query. The query is executed
     * in a streaming fashion which means that the method returns as soon as the first results are ready.
     *
     * @return
     */
    @Query("select c from MeteringUnit c")
    Stream<MeteringUnit> streamAll();





}
