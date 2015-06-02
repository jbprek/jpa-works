Equivalent SQL schema
=====================
                                      
      create table CM_EC_EMPLOYEE (                     
          id int8 not null,                             
          name varchar(255),                            
          primary key (id)                              
      )                                                 

      create table CM_EC_EMP_NNAMES (                   
          EMP_ID int8 not null,                         
          nickNames varchar(255)                        
      )                                                 

      create table CM_EC_EMP_VACATION (                 
          EMP_ID int8 not null,                         
          NUM int4,                                     
          ST_DT date                                    
      )                                                 

      alter table CM_EC_EMP_NNAMES                      
          add constraint FK_tni9rovq3hthhjuaawcjnab3l   
          foreign key (EMP_ID)                          
          references CM_EC_EMPLOYEE                     

      alter table CM_EC_EMP_VACATION                    
          add constraint FK_43f753skm3s0uv7egcbhyn84v   
          foreign key (EMP_ID)                          
          references CM_EC_EMPLOYEE       
                        
                        
Problem 
=======

Having issues with @ElementCollection and @Embeddable