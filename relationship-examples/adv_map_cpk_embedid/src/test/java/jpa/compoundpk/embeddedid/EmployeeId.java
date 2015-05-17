package jpa.compoundpk.embeddedid;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by x on 5/17/15.
 */
@Embeddable
public class EmployeeId implements Serializable {
    private long code;
    private String county;

    public EmployeeId() {
    }

    public EmployeeId(long code, String county) {
        this.code = code;
        this.county = county;
    }

    public long getCode() {
        return code;
    }

    public String getCounty() {
        return county;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeId that = (EmployeeId) o;

        if (code != that.code) return false;
        return !(county != null ? !county.equals(that.county) : that.county != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (code ^ (code >>> 32));
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }
}
