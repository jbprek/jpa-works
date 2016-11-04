package jpa.collectionmappings.map_key_basic;

import jpa.collectionmappings.element_collection.Reservation;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo of Maps with Basic key type
 */

@Table(name = "SALESMAN")
@Entity
public class Salesman {

    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    @Column(name="NAME", unique = true)
    private String name;

    @ElementCollection
    @CollectionTable(name="SALESMAN_SALES")
    @MapKeyColumn(name="PRODUCT_TYPE")
    @Column(name="VALUE")
    private Map<String, Double> sales = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="SALESMAN_PHONE")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name="PHONE_NUM")
    private Map<PhoneType, String> phoneNumbers = new HashMap<>();

    @ElementCollection
    @CollectionTable(name="SALESMAN_MEETING")
    @MapKeyTemporal(TemporalType.DATE)
   @AttributeOverrides({
            @AttributeOverride(name="longitude", column=@Column(name="GEO_LON")),
            @AttributeOverride(name="latitude", column = @Column(name="GEO_LAT")),
    })
    private Map<Date, MeetingPoint> meetings = new HashMap<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getSales() {
        return sales;
    }

    public void setSales(Map<String, Double> sales) {
        this.sales = sales;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

//    public Map<Date, String> getMeetings() {
//        return meetings;
//    }
//
//    public void setMeetings(Map<Date, String> meetings) {
//        this.meetings = meetings;
//    }

        public Map<Date, MeetingPoint> getMeetings() {
        return meetings;
    }

    public void setMeetings(Map<Date, MeetingPoint> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Salesman{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sales=").append(getSales());
        sb.append(", phoneNumbers=").append(getPhoneNumbers());
        sb.append(", meetings=").append(getMeetings());
        sb.append('}');
        return sb.toString();
    }
}
