package jpa.collectionmappings.order_column;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.stream.Stream;


public interface PrinterRepository extends Repository<Printer, Long> {


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<Printer> findOne(Long id);

    /**
     * Saves the given {@link Printer}.
     *
     * @param Printer
     * @return
     */
    <S extends Printer> S save(S Printer);




}
