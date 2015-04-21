package org.bagab.projpa.collectionmapping.logical;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class CML_VacationEntry {

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
    public String toString() {
        return "CMS_VacationEntry{" +
                "startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }
}
