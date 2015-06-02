Entity Inheritance
------------------
* [Introduction](#INH_INTRO)
* [Single Table Strategy](#INH_ST)
* [Join Strategy](#INH_J)
* [Table per class Strategy](#INH_TBC)



## <a name="INH_INTRO">Inheritance Introduction</a>
Points to remember:
* Entity Hierachy rules:

    1. The primary key must be defined on the entity that is the root of the entity hierarchy or on a mapped superclass of the entity hierarchy. 
    2. The primary key must be defined exactly once in an entity hierarchy.
 
* Tree Inheritace types specified with @Inheritance( stategy = InheritanceType.[SINGLE_TABLE|JOINED|TABLE_PER_CLASS]
* Single Table is  most performant for a deep hierarchy of polymorphic entity classes.
* Single Table is inefficient in database space used.


### <a name="INH_ST">Single Table Strategy </a>
See the use of @Inheritance(strategy= InheritanceType.SINGLE_TABLE), @DiscriminatorColumn and  @DiscriminatorValue
    
    /* ROOT */
    @Entity
    @Inheritance(strategy= InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name="EMP_TYPE")
    public abstract class Employee {
        @Id
        private long id;
        private String name;
    
    /* Direct subclass of ROOT, no discriminator value specified, entity name will be used as default */
    @Entity
    public class ContractEmployee extends Employee {
        private int dailyRate;
        private int term;
        
    /* Mapped Superclass derived directly from ROOT*/
    @MappedSuperclass
    public abstract class CompanyEmployee extends Employee{
        private int vacationDays;
        
    /* Mapped Superclass subvlass, with discriminator value specified*/    
    @Entity
    @DiscriminatorValue("FT_EMP")
    public class FullTimeEmployee extends CompanyEmployee {
        private int salary;
        private int pension;
    
    /* Mapped Superclass subclass, with discriminator value specified*/        
    @Entity
    @DiscriminatorValue("PT_EMP")
    public class PartTimeEmployee extends CompanyEmployee{
        private int hourlyRate;
    
### <a name="INH_J">Join Strategy </a>
See the use of @Inheritance(strategy= InheritanceType.JOINED), @DiscriminatorColumn and  @DiscriminatorValue
         
    @Entity
    @Inheritance(strategy= InheritanceType.JOINED)
    @DiscriminatorColumn(name="EMP_TYPE", discriminatorType = DiscriminatorType.INTEGER)
    public abstract class Employee {
        @Id
        @GeneratedValue
        private long id;
        ...
        
    @Entity
    @DiscriminatorValue("1")
    public class ContractEmployee extends Employee {
       ....
    
    @MappedSuperclass
    public abstract class CompanyEmployee extends Employee{
        ....
    
    @Entity
    @DiscriminatorValue("2")
    public class FullTimeEmployee extends CompanyEmployee {
        ....
        
    @Entity
    @DiscriminatorValue("3")
    public class PartTimeEmployee extends CompanyEmployee{
        ....
        
### <a name="INH_TBC">Table per class Strategy </a>
See the use of @Inheritance(strategy= InheritanceType.TABLE_PER_CLASS), @DiscriminatorColumn and  @DiscriminatorValue, also see the use of  @AttributeOverrides and @AssociationOverride
         
    @Entity
    @Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
    @DiscriminatorColumn(name="EMP_TYPE")
    public abstract class Employee {
    
        @Id
        // @GeneratedValue Is NOT ALLOWED
        private long id;
        
    @Table(name="CONTRACT_EMP")
    @Entity
    @AttributeOverrides({
            @AttributeOverride(name="name",column=@Column(name="FULLNAME")),
            @AttributeOverride(name="startDate",column=@Column(name="SDATE"))
    })
    public class ContractEmployee extends Employee {
    .... 
    
    @MappedSuperclass
    public abstract class CompanyEmployee extends Employee{
    ....
    
    @Table(name="FULTIME_EMP")
    @Entity
    @AssociationOverride(name="department",joinColumns = @JoinColumn(name="DPT"))
    public class FullTimeEmployee extends CompanyEmployee  
    ....
    @Table(name="PRTTIME_EMP")
    @Entity
    @AttributeOverride(name="manager", column=@Column(name="MGR"))
    public class PartTimeEmployee extends CompanyEmployee{
    ....

----
