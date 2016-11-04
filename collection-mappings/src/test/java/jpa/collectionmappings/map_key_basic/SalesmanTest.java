package jpa.collectionmappings.map_key_basic;


import jpa.collectionmappings.order_column.PrintJob;
import jpa.collectionmappings.order_column.PrintJobRepository;
import jpa.collectionmappings.order_column.Printer;
import jpa.collectionmappings.order_column.PrinterRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by john_000 on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest

@Transactional(propagation = Propagation.REQUIRED)
public class SalesmanTest {

    static Logger log = Logger.getLogger(SalesmanTest.class);

    @Autowired
    private SalesmanRepository repository;



    @Test
    public void test() throws InterruptedException {


        Salesman salesman = new Salesman();
        salesman.setName("George");

        Map<String, Double> sales = salesman.getSales();
        sales.put("BOOKS", 1000.0);
        sales.put("PENCIL", 2000.0);
        sales.put("NOTEPAD", 3000.0);

        Map<PhoneType, String> phones = new HashMap<>();//salesman.getPhoneNumbers();
        phones.put(PhoneType.BUSINESS, "12345");
        phones.put(PhoneType.HOME, "0012345");
        phones.put(PhoneType.MOBILE, "9912345");

        salesman.setPhoneNumbers(phones);

        Map<Date, MeetingPoint> meetings = salesman.getMeetings();
        meetings.put(java.sql.Date.valueOf(LocalDate.of(2015, 12, 31)), new MeetingPoint(32.1, 33.2));
        meetings.put(java.sql.Date.valueOf(LocalDate.of(2016, 12, 31)), new MeetingPoint(45.1, 22.2));


//        Map<Date, String> meetings = salesman.getMeetings();
//        meetings.put(java.sql.Date.valueOf(LocalDate.of(2015, 12, 31)), "M1");
//        meetings.put(java.sql.Date.valueOf(LocalDate.of(2016, 12, 31)), "M2");

        Long id = repository.save(salesman).getId();

        Optional<Salesman> unit1 = repository.findOne(id);
        assertTrue(unit1.isPresent());

        //
        log.info("$$$"+unit1.get());
    }


}
