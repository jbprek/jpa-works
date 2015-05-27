package jpa.callbacks.model;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by x on 5/3/15.
 */
@Stateless
public class JDBCServiceBean {
    public static Logger log = Logger.getLogger(JDBCServiceBean.class.getName());


    @Resource(name = "JpaWorksDS")
    private DataSource datasource;

    private Connection connection;
    private String insStmQuery = "INSERT INTO ATCB_EMPLOYEE VALUES";
    private PreparedStatement insStm;
    private String findStmQuery = "INSERT INTO ATCB_EMPLOYEE VALUES";
    private PreparedStatement findStm;
    private String updateStmQuery = "INSERT INTO ATCB_EMPLOYEE VALUES";
    private PreparedStatement updateStm;
    private String deleteStmQuery = "INSERT INTO ATCB_EMPLOYEE VALUES";
    private PreparedStatement deleteStm;


    @PostConstruct
    private void setup() {
        try (Connection c = datasource.getConnection() ) {
              connection = c;
        } catch (SQLException e) {
            connection = null;
            log.warning(e.toString());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    private void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                log.warning(e.toString());
            }
        }
    }


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

    public void delete(Employee e) {
        Employee d = em.merge(e);
        em.remove(d);
    }

    public Employee update(long id, String newName) {
        Employee e = em.find(Employee.class, id);
        if (e != null)
            e.setName(newName);

        return e;
    }



}
