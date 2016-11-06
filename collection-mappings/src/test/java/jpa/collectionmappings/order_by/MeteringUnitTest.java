package jpa.collectionmappings.order_by;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by john_000 on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@Transactional(propagation = Propagation.REQUIRES_NEW)

public class MeteringUnitTest {

    static Logger log = Logger.getLogger(MeteringUnitTest.class);

    @Autowired
    private MeteringUnitRepository meteringUnitRepository;

    @Autowired
    private SensorRepository sensorRepository;



    @Test
    public void createReadDeleteTest() throws InterruptedException {

        MeteringUnit unit = new MeteringUnit();

        Long id = unit.getId();

        log.info("### unit=" + unit);

        Sensor s1 = new Sensor(java.sql.Timestamp.from(Instant.now().minus(10, ChronoUnit.SECONDS)), 0.5);
        unit.getSensors().add(s1);

        Sensor s2 = new Sensor(java.sql.Timestamp.from(Instant.now().minus(5, ChronoUnit.SECONDS)), 0.7);
        unit.getSensors().add(s2);

        Sensor s3 = new Sensor(java.sql.Timestamp.from(Instant.now()), 0.9);
        unit.getSensors().add(s3);




//        unit = meteringUnitRepository.findOne(id).get();
//        unit.setSensors(Arrays.asList(s1, s2, s3));
        unit = meteringUnitRepository.save(unit);

        Optional<MeteringUnit> unit1 = meteringUnitRepository.findOne(unit.getId());
        assertTrue(unit1.isPresent());

        // Sensor info is displayed in descending order
        log.info(unit1.get());
        List<Sensor> sensors = unit1.get().getSensors();
        sensors.forEach(w->log.info("\t"+w));
    }


}
