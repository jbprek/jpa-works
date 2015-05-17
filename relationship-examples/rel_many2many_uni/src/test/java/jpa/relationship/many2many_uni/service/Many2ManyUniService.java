package jpa.relationship.many2many_uni.service;

import jpa.relationship.many2many_uni.model.Employee;
import jpa.relationship.many2many_uni.model.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by x on 5/5/15.
 */
@Stateless
public class Many2ManyUniService {
    public static Logger log = Logger.getLogger(Many2ManyUniService.class.getName());


    @PersistenceContext(name = "test-relationships")
    private EntityManager em;

    public Employee createEmployee(String name) {
        log.info("Create Employee");
        Employee e = new Employee();
        e.setName(name);
        em.persist(e);
        return e;
    }

    public Employee findEmployee(long id) {
        log.info("Find Employee");
        return em.find(Employee.class, id);
    }

    public Project createProject(String name) {
        log.info("Create Project");
        Project e = new Project();
        e.setName(name);
        em.persist(e);
        return e;
    }

    public Project findProject(long id) {
        log.info("Find Project");
        return em.find(Project.class, id);
    }

    public void assignToProject(long employeeId, long ProjectId) {
        log.info("Assign Project");
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Project p = findProject(ProjectId);
        Objects.nonNull(p);

        e.getProjects().add(p);
    }

    public void dismissFromProject(long employeeId, long ProjectId) {
        log.info("Assign Project");
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);

        Project p = findProject(ProjectId);
        Objects.nonNull(p);

        e.getProjects().remove(p);
    }

    public Set<Project> getEmployeesProjects(long employeeId){
        Employee e = findEmployee(employeeId);
        Objects.nonNull(e);
        return e.getProjects();
    }

}
