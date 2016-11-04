package jpa.collectionmappings.element_collection;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by john_000 on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest

@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TenantTest {

    static Logger log = Logger.getLogger(TenantTest.class);

    @Autowired
    private TenantRepository tenantRepository;

    @Test
    public void createReadDeleteTest() {

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(Reservation.createNew(LocalDate.of(2017, 11, 10), 1));
        reservations.add(Reservation.createNew( LocalDate.of(2017, 10, 25),2));
        Tenant t1 = tenantRepository.save( Tenant.createNew("John", reservations, Arrays.asList("Blue towels","White roses" )));

        reservations = new ArrayList<>();
        reservations.add(Reservation.createNew(LocalDate.of(2018, 11, 10), 1));
        reservations.add(Reservation.createNew( LocalDate.of(2018, 10, 25),2));
        Tenant t2 =tenantRepository.save( Tenant.createNew("George", reservations, Arrays.asList("White towels","Red roses" )));

        Optional<Tenant> ot1 = tenantRepository.findByName("John");
        assertTrue(ot1.isPresent());
        Optional<Tenant> ot2  = tenantRepository.findByName("George");
        assertTrue(ot2.isPresent());
//
	try (Stream<Tenant> stream = tenantRepository.streamAllTenants()) {
            assertThat(stream.collect(Collectors.toList()), hasItems(ot1.get(), ot2.get()));
//        stream.forEach(w->log.info(w));
        }
    }


}
