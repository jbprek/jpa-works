package jpa.relationship.many2many_state;

/**
 * Created by x on 5/17/15.
 */

public class ProjectAssignementId {
    private long employeeId;
    private long projectId;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
