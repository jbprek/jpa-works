package jpa.collectionmappings.map_key_basic;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Used by Salesman
 */
@Embeddable
public class MeetingPoint implements Serializable{
    public double longitude;
    public double latitude;


    public MeetingPoint() {
    }

    public MeetingPoint(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MeetingPoint{");
        sb.append("longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append('}');
        return sb.toString();
    }
}
