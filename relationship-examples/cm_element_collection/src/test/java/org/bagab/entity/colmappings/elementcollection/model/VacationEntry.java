package org.bagab.entity.colmappings.elementcollection.model;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

/**
 * @author prekezes.
 */
@Embeddable
public class VacationEntry {
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private int duration;

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
}
