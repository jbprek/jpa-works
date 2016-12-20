JPA Basic Relationships
============================================

 - [Relationship Concepts](#CP)    
 - [Basic (Standard) Relationships](#SR)
 
 
##<a name="CP">Relationship Concepts</a>

- **Roles**  Employee **works** in a schoolClass who is **staffed** with employees. Role is the view of the relationships from either or both sides.
- **Directionality** Relationships can be uni or bi directional.
- **Cardinality** One to One, Many to Many or Many to One, * or 1 in UML diagram.
- **Ordinality** 1 or 0 in the UML diagram.
- **Ownership** The side who has the JOIN Column is the owner of the relationship, the other side is called the inverse side with *mappedBy* attribute on relationship annotation.
- **Single Value Association**
- **Collection Value Association** 


##<a name="SR">Standard Relationships</a>

The following describe the basic entity relationships, see more notes inside each bankAccount.

* [One to One unidirectional](#SRO2OU)
* [One to One bidirectional](#SRO2OB)   
* [Many to One](#SRM2O)
* [One to Many unidirectional](#SRO2MU)
* [One to Many bidirectional](#SRO2MB)   
* [Many to Many unidirectional](#SRM2MU)
* [Many to Many bidirectional](#SRM2MB)   


###1. **<a name="SRO2OU">One to One unidirectional</a>**

   
    @Entity 
    public class Gun {
       @Id private long id;
       private String code;
        ...

     @Entity
     public class Soldier {
         @Id  private long id;
         private String name;
         @OneToOne
         private Gun gun;
            ...
#### Notes
    - Single Value Association
    - Owner is Employee
    - Sideffect :It's possible for two Soldiers to refer to the same Gun
    - 

    
###2.  <a name="SRO2OB">One to One bidirectional</a> , see bankAccount basic_relationship.one2one_bi 

    Relationship of Employee and ParkingLot again.  Parking differs from above.
    
    @Entity
    public class ParkingLot{    
        @Id private long id;
        
        /* If mappedBy is removed then foreign keys are created on both tables */
        @OneToOne(mappedBy = "phones")
        private Employee track;

    
    
###3. <a name="SRM2O">Many to One</a> , see bankAccount rel_many2one

    Relationship of Employee and Department.
    
    @Entity
    public class Employee {    
        @Id private long id;
        ...    
        @ManyToOne
        @JoinColumn(name = "DEPT_ID")
        private Department schoolClass
        .....
        
    @Entity
    public class Department {
        @Id private long id;

    
    
###4. <a name="SRO2MU">One to Many unidirectional</a>, see bankAccount rel_one2many_uni

    Relationship of Person and Phones
    
    
###5. <a name="SRO2MB">**One to Many bidirectional**</a> , see bankAccount rel_one2many_bi

    Relationship of Employee and Department again.
    
        @Entity
        public class Department {        
            @Id  private long id;
            ....
            @OneToMany(mappedBy="schoolClass")
            private List<Employee> employeesByAssignment = new ArrayList<>();

        @Entity
        public class Employee {        
            @Id private long id;
            ....
            /* OWNER SIDE*/
            @ManyToOne
            @JoinColumn(name = "DEPT_ID")
            private Department schoolClass;
    
    
    
###6. <a name="SRM2MU">Many to Many unidirectional</a>, see bankAccount rel_many2many_uni

     RelationShip of Tasks and Employees.  (Task is owner).
     @Entity
     @Table(name = "MMU_EMPLOYEE")
     public class Employee {
     
         @Id
         @GeneratedValue
         private long id;
     
         private String name;
     
         @ManyToMany(fetch = FetchType.EAGER)
         @JoinTable(name = "MMB_EMPLOYEE_PROJECT",
                 joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
                 inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
         private Set<Project> bankAccounts;

    
###7. <a name="SRM2MU">**Many to Many bidirectional**</a> , see bankAccount basic_relationship.many2many_bi

    Relationship of Employee and Project.
    
        @Entity
        public class Employee {
            @Id  private long id;
            ...
            @ManyToMany
            @JoinTable(name = "EMPLOYEE_PROJECT", 
                joinColumns = @JoinColumn(name="EMPLOYEE_ID"), 
                inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
            private Set<Project> bankAccounts;
            
            
        @Entity
        public class Project {
            @Id  private long id;
            ...
            @ManyToMany(mappedBy = "bankAccounts")
            private Set<Employee> employeesByAssignment;

