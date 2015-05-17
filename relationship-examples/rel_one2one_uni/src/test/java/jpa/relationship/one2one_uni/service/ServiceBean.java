package jpa.relationship.one2one_uni.service;

import jpa.relationship.one2one_uni.model.Employee;
import jpa.relationship.one2one_uni.model.ParkingLot;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class ServiceBean {
    public static Logger log = Logger.getLogger(ServiceBean.class.getName());

    @PersistenceContext(name = "test-relationships")
    private EntityManager em;


    public Employee createEmployee(String name) {
        log.info("Create Employee");
        Employee emp = new Employee();
        emp.setName(name);
        em.persist(emp);
        return emp;
    }

    public Employee findEmployee(long id) {
        log.info("Find Employee");
        return em.find(Employee.class, id);
    }

    public ParkingLot createParkingLot(String code) {
        log.info("Create ParkingLot");
        ParkingLot lot = new ParkingLot();
        lot.setName(code);
        em.persist(lot);
        return lot;
    }

    public ParkingLot findLot(long id) {
        log.info("Find ParkingLot");
        return em.find(ParkingLot.class, id);
    }

    public void parkingAssign(long employeeId, long parkingId) {
        log.info("Assign ParkingLot");
        Employee e = findEmployee(employeeId);
        ParkingLot l  = findLot(parkingId);
        e.setParkingLot(l);
    }

    public void freeParkingLot(long employeeId){
        log.info("Assign Employee");
        Employee e = findEmployee(employeeId);
        e.setParkingLot(null);
    }

}
