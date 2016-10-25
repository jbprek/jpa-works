package jpa.basicmapping.o2mu;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="TELCO_PHONE")
public class Phone {

    @GeneratedValue
    @Id private long id;

    @Basic(optional = false)
    private String code;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
