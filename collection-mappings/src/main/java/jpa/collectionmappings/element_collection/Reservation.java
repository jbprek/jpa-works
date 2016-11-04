package jpa.collectionmappings.element_collection;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Embeddable
public class Reservation implements Serializable, Comparable {
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private int duration;


    static Reservation createNew(LocalDate startDate, int duration) {
        Reservation r = new Reservation();
        r.setStartDate(java.sql.Date.valueOf(startDate));
        r.setDuration(duration);
        return r;
    }


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
        Reservation that = (Reservation) o;
        return Objects.equals(duration, that.duration) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, duration);
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getStartDate().compareTo(((Reservation)o).startDate);
    }
}
