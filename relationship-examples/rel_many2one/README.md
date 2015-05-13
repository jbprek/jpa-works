Corresponding SQL Schema
========================
    
    create table MO_DEPARTMENT (                          
        id int8 not null,                                 
        name varchar(255),                                
        primary key (id)                                  
    )                                                     
    create table MO_EMPLOYEE (                            
        id int8 not null,                                 
        name varchar(255),                                
        DEPT_ID int8,                                     
        primary key (id)                                  
    )                                                     
    alter table MOU_EMPLOYEE                              
        add constraint FK_tmgl292n7t7e3xpfn3txim49q       
        foreign key (department_id)                       
        references MOU_DEPARTMENT     
                            
    alter table MO_EMPLOYEE                               
        add constraint FK_9qb2j3ghgd621bl9yso3kr4r5       
        foreign key (DEPT_ID)                             
        references MO_DEPARTMENT                          


Notes      
=====

1. Finding an Employee entity involves a join with Department
--------------------------------------------------------------
                                         
   select                                         
       employee0_.id as id1_3_0_,                 
       employee0_.DEPT_ID as DEPT_ID3_3_0_,       
       employee0_.name as name2_3_0_,             
       department1_.id as id1_2_1_,               
       department1_.name as name2_2_1_            
   from                                           
       MO_EMPLOYEE employee0_                     
   left outer join                                
       MO_DEPARTMENT department1_                 
           on employee0_.DEPT_ID=department1_.id  
   where                                          
       employee0_.id=?   
           
 Attempting to resolve the above with @ManyToOne(fetch=FetchType.LAZY) causes failure in test           

                            






