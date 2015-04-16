package org.bagab.projpa.relationships.many2one_bi;

import org.bagab.projpa.relationships.one2one_bi.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

/**
 * @author prekezes.
 */
@Entity
@Table(name="MANY_TO_ONE_BI_DEPARTMENT")
public class Department {
    @Id private long id;

    private String name;

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

    @OneToMany(mappedBy = "department")
    Collection<Employee>  employees;
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
