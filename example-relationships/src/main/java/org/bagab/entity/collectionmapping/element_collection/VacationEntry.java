package org.bagab.entity.collectionmapping.element_collection;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class VacationEntry {

    @Temporal(TemporalType.DATE)
    private Date startDate;

    private int duration;

   /*---------- GET SET --------------------*/

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

    //------- Hash Code and Equals ---------------/

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
