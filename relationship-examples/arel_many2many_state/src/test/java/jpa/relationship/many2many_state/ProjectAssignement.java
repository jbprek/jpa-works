package jpa.relationship.many2many_state;

import org.bagab.entity.relationships.many2many.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by x on 5/17/15.
 */

@Table(name = "AREL_MMBST_EMPLOYEE_PROJECT")
@Entity
@IdClass(value = ProjectAssignementId.class)
public class ProjectAssignement {

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "RROJ_ID")
    private Project project;
    private Date startDate;
    private String jobDescription;


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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
