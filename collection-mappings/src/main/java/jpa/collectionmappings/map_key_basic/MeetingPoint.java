package jpa.collectionmappings.map_key_basic;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Used by Salesman
 */
@Embeddable
public class MeetingPoint implements Serializable{
    public double longititude;
    public double lattitude;


    public MeetingPoint() {
    }

    public MeetingPoint(double longititude, double lattitude) {
        this.longititude = longititude;
        this.lattitude = lattitude;
    }

    public double getLongititude() {
        return longititude;
    }

    public void setLongititude(double longititude) {
        this.longititude = longititude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MeetingPoint{");
        sb.append("longititude=").append(longititude);
        sb.append(", lattitude=").append(lattitude);
        sb.append('}');
        return sb.toString();
    }
}
