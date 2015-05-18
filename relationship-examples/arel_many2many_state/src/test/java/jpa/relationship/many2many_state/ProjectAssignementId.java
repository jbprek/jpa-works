package jpa.relationship.many2many_state;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by x on 5/17/15.
 */

@Embeddable
public class ProjectAssignementId implements Serializable {
    private long employeeId;
    private long projectId;

    public long getEmployeeId() {
        return employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectAssignementId that = (ProjectAssignementId) o;

        if (employeeId != that.employeeId) return false;
        return projectId == that.projectId;

    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        return result;
    }
}
