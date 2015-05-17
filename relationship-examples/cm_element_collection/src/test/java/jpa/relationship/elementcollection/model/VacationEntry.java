package jpa.relationship.elementcollection.model;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Embeddable
public class VacationEntry implements Serializable, Comparable {
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private int duration;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationEntry that = (VacationEntry) o;
        return Objects.equals(duration, that.duration) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, duration);
    }


    @Override
    public String toString() {
        return "VacationEntry{" +
                "startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getStartDate().compareTo(((VacationEntry)o).startDate);
    }
}
