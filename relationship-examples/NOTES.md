JPA Relationships and operations on entities
============================================

TODO
----


Standard Relationships
----------------------

The following describe the basic entity relationships, see more notes inside each project.

Key terms : *Single Value Association*, *Collection Value Association*.

1. **One to One unidirectional**, see project rel_one2one_uni

    Relationship of Employee and ParkingLot:
    
        @Entity
        public class Employee {
            @Id private long id;        
            @OneToOne
            //@JoinColumn(name = "PARKING_ID")
            private ParkingLotEntity parkingLot;
            ...

        @Entity
        public class ParkingLotEntity {
            @Id private long id;
            ...

    Note: It's possible for two Employess to refer to the same ParkingLot

    
2. One to One bidirectional , see project rel_one2one_bi 

    Relationship of Employee and ParkingLot again.
    
    
3. Many to One , see project rel_many2one

    Relationship of Employee and Department.
    
    
4. One to Many unidirectional, see project rel_one2many_uni

    Relationship of Person and Phones
    
    
5. **One to Many bidirectional** , see project rel_one2many_bi

    Relationship of Employee and Department again.
    
        @Entity
        public class Department {        
            @Id  private long id;
            ....
            @OneToMany(mappedBy="department")
            private List<Employee> employees = new ArrayList<>();

        @Entity
        public class Employee {        
            @Id private long id;
            ....
            /* OWNER SIDE*/
            @ManyToOne
            @JoinColumn(name = "DEPT_ID")
            private Department department;
    
    
    
6. Many to Many unidirectional, see project rel_many2many_uni

     RelationShip of Tasks and Employees.  (Task is owner).
    
7. **Many to Many bidirectional** , see project rel_many2many_bi

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
            private Set<Employee> employees;

8. **Embeddable use**, project embed_example
Demonstration of @Embeddable 

        @Embeddable
        @Access(AccessType.FIELD)
        public class Address implements Serializable {
            private String street;
            private String number;
            private String town;
            private String country;
            @Column(name="ZIP_CODE")
            private String zip;
            
        @Entity
        public class Employee implements Serializable {
            @Id  private long id;
            @Embedded
            @AttributeOverrides({
                    @AttributeOverride(name= "country", column = @Column(name="CNTRY")),
                    @AttributeOverride(name= "zip", column = @Column(name="ZIP")),
            })
            private Address address; 
            ....

Collection Mappings
-------------------

1. **Element collection example**, see project cm_element_collection 

    Collection Mapping of Employee to NickName(s) and VacationEntry(ies). 
    
        @Embeddable
        public class VacationEntry {
            @Temporal(TemporalType.DATE)
            private Date startDate;
            private int duration;
            
        @Entity
        public class Employee {
            @Id private long id;
               
            private String name;
        
            @ElementCollection
            @CollectionTable(name="CM_EC_EMP_VACATION",
                             joinColumns = @JoinColumn(name="EMP_ID"))
            @AttributeOverrides({ .. })
            private List<VacationEntry> vacationEntries  = new ArrayList<>();
        
            @ElementCollection
            @CollectionTable(name = "CM_EC_EMP_NNAMES", joinColumns = @JoinColumn(name = "EMP_ID"))
            private List<String> nickNames = new ArrayList<>();


    
2. List Ordering , see project  cm_list
    
    - Use of @OrderBy in Employees-Department relationship, Unresolved **problem**: cannot obtain sorted list of department employess.
    - Example of @OrderColumn  with PrintQueue PrintJob, same  **problem** cannot get them in proper order
    
3. **Map mapping keyed by basic type**, String in our case, see project cm_map_key_basic
    - Key is String under package jpa.relationship.mapuse.stringkey
    
        Person with phones mapped by category
         
        @Entity
        public class PersonStringPhoneType {        
            @Id private int id;
            ....
            @ElementCollection
            @CollectionTable(name = "PERSON_PHONE")
            @MapKeyColumn(name = "PHONE_TYPE")
            @Column(name = "PHONE_NUM")
            private Map<String, String> phoneNumbers = new HashMap<>();

4. **Map mapping keyed by enum**, see project cm_map_key_enum       
        
    - Key is Emum under package jpa.relationship.mapuse.emumkey
    
     Same as above using an Enum instead of a String.
        
        public enum PhoneType {
            HOME, MOBILE
        }
         
        @Entity
        public class PersonEnumPhoneType {        
            @Id  private int id;
            ....
            @ElementCollection
            @CollectionTable(name = "EMP_PHONE")
            @MapKeyEnumerated(EnumType.STRING)
            @Column(name = "PHONE_NUM")
            private Map<PhoneType, String> phoneNumbers = new HashMap<>();
 
5. **Map used in One to Many relationship**, see project cm_map_one2many

        @Entity
        public class Employee {        
            @Id
            private long id;
            ...        
            @ManyToOne
            @JoinColumn(name = "DEPT_ID")
            private Department department;
            
            
        @Entity
        public class Department {        
            @Id  private long id;
            ...
            @OneToMany(mappedBy="department")
            @MapKeyColumn(name="CUB_ID", nullable = true)
            private Map<String, Employee> employeesByCubicle;

6. **Map used in Many to Many relationship**, see project cm_map_many2many

        @Entity
        public class Employee {        
            @Id private long id;
            ...
            @ManyToMany
            @JoinTable(name = "CM_MMB_EMPLOYEE_PROJECT",
                    joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
                    inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
            @MapKeyColumn(name="ASSIGNEMENT")
            private Map<String, Project> projectsByAssignement = new HashMap<>();
            
        @Entity
        public class Project {
            @Id  private long id;
            ...
            @ManyToMany(mappedBy = "projectsByAssignement")
            private Set<Employee> employees = new HashSet<>();
            
    ***Not Working*** , see in DDL below that PK in CM_MMB_EMPLOYEE_PROJECT is (EMPLOYEE_ID, ASSIGNEMENT) instead of the expected (EMPLOYEE_ID, PROJECT_ID)
     
        create table CM_MMB_EMPLOYEE (
            id bigint not null auto_increment, 
            name varchar(255), 
            primary key (id))
        create table CM_MMB_EMPLOYEE_PROJECT (
            EMPLOYEE_ID bigint not null,
            PROJECT_ID bigint not null, 
            ASSIGNEMENT varchar(255) not null, 
            primary key (EMPLOYEE_ID, ASSIGNEMENT))
        create table CM_MMB_PROJECT (
            id bigint not null auto_increment, 
            name varchar(255), 
            primary key (id))
        alter table CM_MMB_EMPLOYEE_PROJECT 
            add constraint FK_479ucto5kbsc9tqx4v2equvvw 
            foreign key (PROJECT_ID) references CM_MMB_PROJECT (id) 
            
Advanced Topics - Primary Key
---------------------------
1. **Compound PK @IdClass** , adv_map_cpk_idclass

        // IdClass - No Setters
        public class EmployeeId implements Serializable {
            private long code;
            private String county;
            
        @Entity
        @IdClass(value = EmployeeId.class)
        public class Employee implements Serializable {    
            // Same fields as IdClass
            @Id
            private long code;
            @Id
            private String county;
            ...    
    
2. **Compound PK @EmbeddedId**, adv_map_cpk_embedid

        @Embeddable
        public class EmployeeId implements Serializable {
            private long code;
            private String county;
    
        @Entity
        public class Employee implements Serializable {    
            @EmbeddedId
            private EmployeeId id;

Advanced Topics - Relationships
-----------------------------

1. **Many To Many with relationship state**, project arel_many2many_state
**Unresolved problem** follows the entities as they should be:


    //Employee Entity
    @Entity
    public class Employee {
        @Id  private long id;
        private String name;
        @OneToMany(mappedBy = "employee")
        private Set<ProjectAssignement> projectAssignements = new HashSet<>();

    //Project Entity
    @Entity
    public class Project {
        @Id private long id;
        private String name;
        @OneToMany(mappedBy = "project")
        private Set<ProjectAssignement> projectAssignements = new HashSet<>();

    //IdClass for ProjectAssignement entity
    public class ProjectAssignementId implements Serializable {
        private long employeeId;
        private long projectId;
   
    //ProjectAssignement Entity
    @Entity
    @IdClass(value = ProjectAssignementId.class)
    public class ProjectAssignement {
        @Id
        @ManyToOne
        @JoinColumn(name = "EMP_ID")
        private Employee employee;
        Id
        @ManyToOne
        @JoinColumn(name = "RROJ_ID")
        private Project project;
   

**Problem Description** Use of Id class combined with @Id within ProjectAssignement doesn't seem to work.
As a workaround a generated surrogate key is been used.

Weaknesses
----------

- Unresolved issues with @OrderBy project cm_list
- Unresolved issues with ManyToMany and Map(s) project cm_map_many2many
- Unresolved issues with @IdClass when their fields are used as part of @OneToMany, project arel_many2many_state
    
Future
------
- Explore @OrderBy when applied at @ElementCollection of basic type

