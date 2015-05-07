package org.bagab.entity.collectionmapping.element_collection;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class VacationEntry {

    private Date startDate;

    private int duration;

   // Get Set

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
}
