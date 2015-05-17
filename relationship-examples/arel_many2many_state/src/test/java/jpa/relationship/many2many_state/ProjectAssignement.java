package jpa.relationship.many2many_state;

import org.bagab.entity.relationships.many2many.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by x on 5/17/15.
 */

@Table(name = "EMPLOYEE_PROJECT")
@Entity
//@IdClass(value = ProjectAssignementId.class)
public class ProjectAssignement {
   @Id
   @GeneratedValue
   private long id;
//
//    @Column(name = "EMP_ID")
//    private long employeeId;
//    @Id
//    @Column(name = "RROJ_ID")
//
//    private long projectId;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "RROJ_ID")
    private Project project;
    //
    private String jobDescription;

//    public long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(long employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public long getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(long projectId) {
//        this.projectId = projectId;
//    }


    public long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
