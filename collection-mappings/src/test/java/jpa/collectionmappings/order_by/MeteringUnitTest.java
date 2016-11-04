package jpa.collectionmappings.order_by;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by john_000 on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest

@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MeteringUnitTest {

    static Logger log = Logger.getLogger(MeteringUnitTest.class);

    @Autowired
    private MeteringUnitRepository unitRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    public void createReadDeleteTest() throws InterruptedException {

        MeteringUnit unit = new MeteringUnit();

        Long id = unitRepository.save(unit).getId();


        Sensor s1 = new Sensor(java.sql.Timestamp.from(Instant.now()), 0.5, unit);
        Thread.sleep(1000);
        Sensor s2 = new Sensor(java.sql.Timestamp.from(Instant.now()), 0.7, unit);
        Thread.sleep(1000);
        Sensor s3 = new Sensor(java.sql.Timestamp.from(Instant.now()), 0.9, unit);
        Thread.sleep(1000);

        sensorRepository.save(s1);
        sensorRepository.save(s2);
        sensorRepository.save(s3);

        unit.setSensors(Arrays.asList(s1, s2, s3));
        unitRepository.save(unit);

        Optional<MeteringUnit> unit1 = unitRepository.findOne(id);
        assertTrue(unit1.isPresent());

        // Sensor info is displayed in descending order
        log.info(unit1.get());
    }


}
