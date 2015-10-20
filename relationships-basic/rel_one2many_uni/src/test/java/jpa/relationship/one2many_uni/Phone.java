package jpa.relationship.one2many_uni;

import javax.persistence.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="O2MU_PHONE")
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
