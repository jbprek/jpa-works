package jpa.collectionmappings.order_column;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;


public interface PrintJobRepository extends Repository<PrintJob, Long> {


    /**
     * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
     *
     * @param id
     * @return
     */
    Optional<PrintJob> findOne(Long id);

    /**
     * Saves the given {@link PrintJob}.
     *
     * @param PrintJob
     * @return
     */
    <S extends PrintJob> S save(S PrintJob);




}
