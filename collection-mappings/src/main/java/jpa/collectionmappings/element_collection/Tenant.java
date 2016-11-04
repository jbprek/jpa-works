package jpa.collectionmappings.element_collection;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author prekezes.
 */

@Table(name = "TENANT")
@Entity
public class Tenant {
    @GeneratedValue
    @Id
    private long id;

    @Basic(optional = false)
    @Column(name="NAME", unique = true)
    private String name;

    @ElementCollection//(fetch = FetchType.EAGER /*, targetClass=Reservation.class*/)
    @CollectionTable(name="TENANT_RESERVATION",
                     joinColumns = @JoinColumn(name="TENANT_ID"))
    @AttributeOverrides({
            @AttributeOverride(name="startDate", column=@Column(name = "ST_DT")),
            @AttributeOverride(name="duration", column=@Column(name = "NUM"))
        })
//    @OrderBy("ST_DT")
    private List<Reservation> reservations;

    @ElementCollection//(fetch = FetchType.EAGER)
    @CollectionTable(name = "TENANT_REQUIREMENT", joinColumns = @JoinColumn(name = "TENANT_ID"))
    @Column(name="REQUIREMENT")
//    @OrderColumn
    private List<String> requirements;



    static Tenant createNew(String name, List<Reservation> reservations, List<String> requirements) {
        Tenant tenant = new Tenant();
        tenant.setName(name);
        tenant.setReservations(reservations);
        tenant.setRequirements(requirements);
        return tenant;
    }


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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tenant{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", reservations=").append(reservations);
        sb.append(", requirements=").append(requirements);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tenant tenant = (Tenant) o;

        if (id != tenant.id) return false;
        return name != null ? name.equals(tenant.name) : tenant.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
