JPA Relationships and operations on entities
============================================
  
##[Collection Mapping](#CM)
* [Introduction](#CMIN)
* [@ElementCollection Example](#CMEC)
* [List Ordering @OrderBy and @OrderColumn](#CMLO)   
* [Map keyed by basic (String)](#CMKB)
* [Map keyed by Enum (String)](#CMKE)
* [Map used in One to Many relationship](#CMOM)
* [Map used in One to Many relationship **Not Working**](#CMMM)
    
##[Mappings](#MP)
* [Use of @Embeddable](#EMBED) 
* [Composite PK - Use of @IdClass](#IDCLASS)   
* [Composite PK - Use of @EmbeddedIds](#EMBEDDEDID) 


## [Advanced Relationships](#ARL)
* [Many to Many with relationship state](#ARLM2MS)



### <a name="IDCLASS">Compound PK @IdClass</a> , adv_map_cpk_idclass

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
    
### <a name="EMBEDDEDID">Compound PK @EmbeddedId</a>, adv_map_cpk_embedid

        @Embeddable
        public class EmployeeId implements Serializable {
            private long code;
            private String county;
    
        @Entity
        public class Employee implements Serializable {    
            @EmbeddedId
            private EmployeeId id;

-------------------

## <a name = "CM">Collection Mappings</a>

###0. <a name = "CMIN">Introduction</a>

####Rules for Maps
* Use the **@MapKeyClass** and **targetEntity/targetClass** elements of the relationship and
element collection mappings to specify the classes when an untyped Map is used.
* Use **@MapKey** with one-to-many or many-to-many relationship Map that is keyed on an attribute
of the target entity.
* Use **@MapKeyJoinColumn** to override the join column of the entity key.
* Use **@Column** to override the column storing the values of an element collection of basic types.
* Use **@MapKeyColumn** to override the column storing the keys when keyed by a basic type.
* Use **@MapKeyTemporal** and **@MapKeyEnumerated** if you need to further qualify a basic key that is  a temporal or enumerated type.
* Use **@AttributeOverride** with a “key.” or “value.” prefix to override the column of an
embeddable attribute type that is a Map key or a value, respectively.

####Summary of Mapping a Map

    Map                         Mapping                 Key Annotation              Value Annotation
    
    Map<Basic,Basic>            @ElementCollection      @MapKeyColumn,              @Column
                                                        @MayKeyEnumerated,
                                                        @MapKeyTemporal
    
    Map<Basic,Embeddable>       @ElementCollection      @MapKeyColumn,              Mapped by embeddable,
                                                        @MayKeyEnumerated,          @AttributeOverride,
                                                        @MapKeyTemporal             @AssociationOverride
    
    Map<Basic,Entity>           @OneToMany,             @MapKey,                    Mapped by entity
                                @ManyToMany             @MapKeyColumn,
                                                        @MayKeyEnumerated,
                                                        @MapKeyTemporal
    
    Map<Embeddable,Basic>       @ElementCollection      Mapped by embeddable,       @Column
                                                        @AttributeOverride
    
    Map<Embeddable,Embeddable>  @ElementCollection      Mapped by embeddable,       Mapped by embeddable,
                                                        @AttributeOverride          @AttributeOverride,
                                                                                    @AssociationOverride
    
    Map<Embeddable,Entity>      @OneToMany,            Mapped by embeddable         Mapped by entity
                                @ManyToMany            @AttributeOverride
    
    Map<Entity,Basic>           @ElementCollection      @MapKeyJoinColumn           @Column
    
    
    Map<Entity,Embeddable>      @ElementCollection      @MapKeyJoinColumn           Mapped by embeddable,
                                                                                    @AttributeOverride,
      
    Map<Entity,Entity>          @OneToMany,             @MapKeyJoinColumn           Mapped by entity
                                @ManyToMany



###1. <a name="CMEC">@ElementCollection Example</a>, see project cm_element_collection 

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


    
###2. <a name="CMLO">List Ordering @OrderBy and @OrderColumn</a> , see project  cm_list
    
    - Use of @OrderBy in Employees-Department relationship, Unresolved **problem**: cannot obtain sorted list of department employess.
    - Example of @OrderColumn  with PrintQueue PrintJob, same  **problem** cannot get them in proper order
    
###3. <a name="CMKB">Map mapping keyed by basic type</a>, String in our case, see project cm_map_key_basic
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

###4. <a name="CMKE">Map mapping keyed by enum</a>, see project cm_map_key_enum       
        
    - Key is Emum under package jpa.relationship.mapuse.emumkey
    
     Same as above using an Enum instead of a String.
        
        public enum PhoneType { HOME, MOBILE }
         
        @Entity
        public class PersonEnumPhoneType {        
            @Id  private int id;
            ....
            @ElementCollection
            @CollectionTable(name = "EMP_PHONE")
            @MapKeyEnumerated(EnumType.STRING)
            @Column(name = "PHONE_NUM")
            private Map<PhoneType, String> phoneNumbers = new HashMap<>();
 
###5. <a name="CMOM">Map used in One to Many relationship</a>, see project cm_map_one2many

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

##6. <a name="CMMM">Map used in Many to Many relationship</a>, see project cm_map_many2many

        @Entity
        public class Employee {        
            @Id private long id;
            ...
            @ManyToMany
            @JoinTable(name = "CM_MMB_EMPLOYEE_PROJECT",
                    joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
                    inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
            @MapKeyColumn(name="ASSIGNEMENT")
            private Map<String, Project> projects = new HashMap<>();
            
        @Entity
        public class Project {
            @Id  private long id;
            ...
            @ManyToMany(mappedBy = "projects")
            private Set<Employee> employeesByAssignment = new HashSet<>();
            
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
 
--------------------


## <a name="ARL">Advanced Topics - Relationships</a>


###1. <a name="ARLM2MS">Many To Many with relationship state</a>, project arel_many2many_state
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

