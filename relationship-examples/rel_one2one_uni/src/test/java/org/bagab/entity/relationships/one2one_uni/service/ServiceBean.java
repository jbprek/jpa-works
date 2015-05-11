package org.bagab.entity.relationships.one2one_uni.service;

import org.bagab.entity.relationships.one2one_uni.model.Employee;
import org.bagab.entity.relationships.one2one_uni.model.ParkingLotEntity;

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

    public ParkingLotEntity createParkingLot(String code) {
        log.info("Create ParkingLotEntity");
        ParkingLotEntity lot = new ParkingLotEntity();
        lot.setName(code);
        em.persist(lot);
        return lot;
    }

    public ParkingLotEntity findLot(long id) {
        log.info("Find ParkingLotEntity");
        return em.find(ParkingLotEntity.class, id);
    }

    public void parkingAssign(long employeeId, long parkingId) {
        log.info("Assign ParkingLotEntity");
        Employee e = findEmployee(employeeId);
        ParkingLotEntity l  = findLot(parkingId);
        e.setParkingLot(l);
    }

    public void freeParkingLot(long employeeId){
        log.info("Assign Employee");
        Employee e = findEmployee(employeeId);
        e.setParkingLot(null);
    }

}
