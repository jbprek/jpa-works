Equivalent SQL schema
=====================
                                      
                             
    create table OOU_EMPLOYEE (                           
        id int8 not null,                                 
        name varchar(255) not null,                       
        parkingLot_id int8,                               
        primary key (id)                                  
    )                                                     

    create table OOU_PARKING_LOT (                        
        id int8 not null,                                 
        name varchar(255) not null,                       
        primary key (id)                                  
    )                                                     

    alter table OOU_EMPLOYEE                              
        add constraint FK_4hsxxjy7930pbfa5cytnphxf2       
        foreign key (parkingLot_id)                       
        references OOU_PARKING_LOT                        

    alter table OOU_EMPLOYEE                              
        add constraint FK_4hsxxjy7930pbfa5cytnphxf2       
        foreign key (parkingLot_id)                       
        references OOU_PARKING_LOT  
                             
