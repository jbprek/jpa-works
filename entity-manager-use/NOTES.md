Entity Manager
==============

- [Persistence Contexts](#PU)
- [Entity Managers](#EM)
    - [Container-Managed Entity Managers](#EM1)
        - [Transaction Scoped ](#EM1.1)
        - [Extended](#EM1.2)
        - [@PersistenceContext Annotation](#EM1.3)
    - [Application Managed Entity Managers](#EM2)
- [Transaction Management](#TM)
- JTA Transaction Management
- Transaction Scoped Persistence Contexts
- Extended Persistence Contexts
    - Persistence Context Collision
    - Persistence Context Inheritance
- Application Managed Persistence Contexts
- Unsynchronized Persistence Contexts

Choosing n Entity Manager
-------------------------



Entity Manager Operations
-------------------------

- Persist an Entity
- Finding an Entity
- Removing an Entity
- Cascading Operations
    - Cascade Persist
    - Cascade Remove
- Clearing the Persistence Context
- Synchronization with the Database
- Detachement and Merging
    - Detachement
    - Merging
    - Working with detached entities
        - Planning for detachement
            - Triggering lazy loading
            - Configuring eager loading
        - Avoiding detachment
            - Transaction view
            - Entity Manager per request
        - Merge strategies
            - Session Facade
            - Edit Session
            - Conversation
      



<a name="CP">Persistence Contexts</a>
--------------------
Terms

- **Persistence Unit**: Named configuration of Entity classes.
- **Persistence Context**: Set of *managed* Entity instances.
- **Entity Manager**: Allows operations on *managed* instances of a Persistence Context.

<a name="EM">Entity Managers</a>
---------------
JPA defines not fewer than 3 types of EMs.

###<a name="EM1">Container-Managed Entity Managers</a>
An EM obtainned in a Java EE environment through the @PersistenceContext annotation is considered container managed.
There are two kind of them examined below.
####<a name="EM1.1">Transaction Scoped Persistence Contexts</a>
Most usually used in the scope of SLSB are created and live within the scope of a JTA transaction.
If a bean calls another bean, within the same tx, Persistence Context is propagated to the called bean, if the call is within the same transaction.
If the called bean starts a new TX ie with REQUIRED_NEW then the Persistence Context is **not** propagated. 
####<a name="EM1.2">Extended Persistence Contexts</a>
Used with SFSB. The stateful session bean is associated with a single extended persistence context that is created when the bean instance is created and closed when the bean
               instance is removed. This has implications for both the association and propagation characteristics of the extended
               persistence context.

####<a name="EM1.3">@PersistenceContext Annotation</a>
### <a name="EM2">Application Managed Entity Managers</a>


Transaction Management
----------------------
- JTA Transaction Management
- Transaction Scoped Persistence Contexts
- Extended Persistence Contexts
    - Persistence Context Collision
    - Persistence Context Inheritance
- Application Managed Persistence Contexts
- Unsynchronized Persistence Contexts

Choosing n Entity Manager
-------------------------



Entity Manager Operations
-------------------------

- Persist an Entity
- Finding an Entity
- Removing an Entity
- Cascading Operations
    - Cascade Persist
    - Cascade Remove
- Clearing the Persistence Context
- Synchronization with the Database
- Detachement and Merging
    - Detachement
    - Merging
    - Working with detached entities
        - Planning for detachement
            - Triggering lazy loading
            - Configuring eager loading
        - Avoiding detachment
            - Transaction view
            - Entity Manager per request
        - Merge strategies
            - Session Facade
            - Edit Session
            - Conversation
      

 - [Relationship Concepts](#CP)    
 - [Basic (Standard) Relationships](#SR)
 
 
 
 
 
 
##<a name="CP">Relationship Concepts</a>

- **Roles**  Employee **works** in a department who is **staffed** with employees. Role is the view of the relationships from either or both sides.
- **Directionality** Relationships can be uni or bi directional.
- **Cardinality** One to One, Many to Many or Many to One, * or 1 in UML diagram.
- **Ordinality** 1 or 0 in the UML diagram.
- **Ownership** The side who has the JOIN Column is the owner of the relationship, the other side is called the inverse side.
- **Single Value Association**
- **Collection Value Association** 


##<a name="SR">Standard Relationships</a>

The following describe the basic entity relationships, see more notes inside each project.

* [One to One unidirectional](#SRO2OU)
* [One to One bidirectional](#SRO2OB)   
* [Many to One](#SRM2O)
* [One to Many unidirectional](#SRO2MU)
* [One to Many bidirectional](#SRO2MB)   
* [Many to Many unidirectional](#SRM2MU)
* [Many to Many bidirectional](#SRM2MB)   


###1. **<a name="SRO2OU">One to One unidirectional</a>**, see project rel_one2one_uni

    Relationship of Employee and ParkingLot:
    
        @Entity
        public class Employee {
            @Id private long id; 
            /* Owner */
            @OneToOne
            //@JoinColumn(name = "PARKING_ID")
            private ParkingLotEntity phones;
            ...

        @Entity
        public class ParkingLotEntity {
            @Id private long id;
            ...
#### Notes
    - Single Value Association
    - Owner is Employee
    - Sideffect :It's possible for two Employess to refer to the same ParkingLot
    - 

    
###2.  <a name="SRO2OB">One to One bidirectional</a> , see project basic_relationship.one2one_bi 

    Relationship of Employee and ParkingLot again.  Parking differs from above.
    
    @Entity
    @Table(name="PARKING_LOT")
    public class ParkingLot{    
        @Id private long id;
        
        /* If mappedBy is removed then foreign keys are created on both tables */
        @OneToOne(mappedBy = "phones")
        private Employee employee;

    
    
###3. <a name="SRM2O">Many to One</a> , see project rel_many2one

    Relationship of Employee and Department.
    
    @Entity
    public class Employee {    
        @Id private long id;
        ...    
        @ManyToOne
        @JoinColumn(name = "DEPT_ID")
        
        
        @Entity
        public class Department {
            @Id private long id;

    
    
###4. <a name="SRO2MU">One to Many unidirectional</a>, see project rel_one2many_uni

    Relationship of Person and Phones
    
    
###5. <a name="SRO2MB">**One to Many bidirectional**</a> , see project rel_one2many_bi

    Relationship of Employee and Department again.
    
        @Entity
        public class Department {        
            @Id  private long id;
            ....
            @OneToMany(mappedBy="department")
            private List<Employee> employeesByAssignment = new ArrayList<>();

        @Entity
        public class Employee {        
            @Id private long id;
            ....
            /* OWNER SIDE*/
            @ManyToOne
            @JoinColumn(name = "DEPT_ID")
            private Department department;
    
    
    
###6. <a name="SRM2MU">Many to Many unidirectional</a>, see project rel_many2many_uni

     RelationShip of Tasks and Employees.  (Task is owner).
    
###7. <a name="SRM2MU">**Many to Many bidirectional**</a> , see project basic_relationship.many2many_bi

    Relationship of Employee and Project.
    
        @Entity
        public class Employee {
            @Id  private long id;
            ...
            @ManyToMany
            @JoinTable(name = "EMPLOYEE_PROJECT", 
                joinColumns = @JoinColumn(name="EMPLOYEE_ID"), 
                inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
            private Set<Project> projects;
            
            
        @Entity
        public class Project {
            @Id  private long id;
            ...
            @ManyToMany(mappedBy = "projects")
            private Set<Employee> employeesByAssignment;

