package jpa.collectionmappings.order_column;



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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * Created by john_000 on 10/30/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@Transactional

public class PrintTest {

    static Logger log = Logger.getLogger(PrintTest.class);

    @Autowired
    private PrinterRepository printerRepository;

    @Autowired
    private PrintJobRepository  printJobRepository;

//    @Autowired
//    public PrintTest(PrinterRepository printerRepository, PrintJobRepository  printJobRepository) {
//        this.printerRepository = printerRepository;
//        this.printJobRepository = printJobRepository;
//    }

    @Test
    public void test() throws InterruptedException {


        Printer printer = printerRepository.save(new Printer());
        Long id = printer.getId();

        List<PrintJob> jobs = Arrays.asList(
                new PrintJob(printer, "Text1"),
                new PrintJob(printer, "Text2"),
                new PrintJob(printer, "Text3") );

        jobs.forEach(w-> {printJobRepository.save(w); printer.getPrintJobs().add(w);});

        printerRepository.save(printer);

        Optional<Printer> unit1 = printerRepository.findOne(id);
        assertTrue(unit1.isPresent());

        //
        log.info("$$$"+unit1.get());
    }


}
