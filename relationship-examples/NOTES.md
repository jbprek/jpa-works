JPA Relationships and operations on entities
============================================

The following describe the basic entity relationships, see more notes inside each project.

Key terms : *Single Value Association*, *Collection Value Association*.

1. One to One unidirectional, see project rel_one2one_uni

    Relationship of Employee and ParkingLot.
    
    
2. One to One bidirectional , see project rel_one2one_bi 

    Relationship of Employee and ParkingLot again.
    
    
3. Many to One , see project rel_many2one

    Relationship of Employee and Department.
    
    
4. One to Many unidirectional, see project rel_one2many_uni

    Relationship of Person and Phones
    
    
5. One to Many bidirectional , see project rel_one2many_bi

    Relationship of Employee and Department again.
    
    
6. Many to Many unidirectional, see project rel_many2many_uni

     RelationShip of Tasks and Employees.  (Task is owner).
    
7. Many to Many bidirectional , see project rel_many2many_bi

    Relationship of Employee and Project.


Collection Mappings
===================

1. Element collection example, see project cm_element_collection 

    Collection Mapping of Employee to NickName(s) and VacationEntry(ies). Unresolved **problem** so far with Entity having two element collections.
    
2. List Ordering , see project  cm_list
    
    - Use of @OrderBy in Employees-Department relationship, Unresolved **problem**: cannot obtain sorted list of department employess.
    - Example of @OrderColumn  with PrintQueue PrintJob, same  **problem** cannot get them in proper order
    
    
Future
=======
- Explore @OrderBy when applied at @ElementCollection of basic type

