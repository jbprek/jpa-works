package jpa.callbacks.model;

import javax.ejb.Stateless;
import javax.persistence.PostPersist;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */

@Stateless
public class EmployeeEntityListener {

    public static Logger log = Logger.getLogger(EmployeeEntityListener.class.getName());

    @PostPersist
    public void persitEvent(Employee employee){
        System.out.println("persitEvent "+employee);

    }
}
