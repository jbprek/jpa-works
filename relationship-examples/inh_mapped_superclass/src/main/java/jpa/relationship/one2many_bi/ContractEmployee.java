package jpa.relationship.one2many_bi;

import javax.persistence.Entity;

/**
 * @author prekezes.
 */
@Entity
public class ContractEmployee extends Employee {
    private int dailyRate;
}
