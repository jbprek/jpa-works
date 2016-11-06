package jpa.collectionmappings.order_by;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by john_000 on 11/4/2016.
 */
@Entity
public class Sensor {

    @GeneratedValue
    @Id
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date measuredAt;

    private Double value;

    @ManyToOne
    @JoinColumn(name = "METERING_UNIT_ID")
    private MeteringUnit meteringUnit;


    public Sensor() {
    }

    public Sensor(Date measuredAt, Double value) {
        this.measuredAt = measuredAt;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getMeasuredAt() {
        return measuredAt;
    }

    public void setMeasuredAt(Date measuredAt) {
        this.measuredAt = measuredAt;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public MeteringUnit getMeteringUnit() {
        return meteringUnit;
    }

    public void setMeteringUnit(MeteringUnit meteringUnit) {
        this.meteringUnit = meteringUnit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sensor{");
        sb.append("id=").append(id);
        sb.append(", measuredAt=").append(measuredAt);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
