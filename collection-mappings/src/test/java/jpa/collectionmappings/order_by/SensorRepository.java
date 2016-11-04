package jpa.collectionmappings.order_by;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.stream.Stream;


public interface SensorRepository extends Repository<Sensor, Long> {


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<Sensor> findOne(Long id);

    /**
     * Saves the given {@link Sensor}.
     *
     * @param Sensor
     * @return
     */
    <S extends Sensor> S save(S Sensor);

    @Query("select s from Sensor s")
    Stream<Sensor> streamAll();





}
