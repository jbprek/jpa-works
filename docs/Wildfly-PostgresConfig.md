Wildfly Postgres configuration
=============================

Jdbc installation
-----------------

###1. Officially recommended is deployment of jdbc-jar in deployments directory


###2. Installation as a module



Tested drivers
--------------
###1.Manually deployed  postgresql-9.4-1201.jdbc4.jar :  Success but

A Warning appears :
INFO [org.jboss.as.connector.deployers.jdbc] (MSC service thread 1-1) JBAS010404: Deploying non-JDBC-compliant driver class org.postgresql.Driver (version 9.2)

###2. Manually deployed  postgresql-9.4-1201.jdbc41.jar :  Success but
INFO  [org.jboss.as.connector.deployers.jdbc] (MSC service thread 1-14) JBAS010404: Deploying non-JDBC-compliant driver class org.postgresql.Driver (version 9.4)


Datasource configuration
------------------------

### XA datasource

In order to configure an XA resource, add the following segment in the <datasources> subsystem  with the relevant values changed.
Note the driver name corresponds to the manually added driver.

    <xa-datasource jndi-name="java:jboss/PostgresXADS" pool-name="PostgresXADS">
        <driver>postgresql-9.4-1201.jdbc41.jar</driver>
        <xa-datasource-property name="ServerName">localhost</xa-datasource-property>
        <xa-datasource-property name="PortNumber">5432</xa-datasource-property>
        <xa-datasource-property name="DatabaseName">wildfly</xa-datasource-property>
        <security>
          <user-name>wildfly</user-name>
          <password>wildfly</password>
        </security>
        <validation>
              <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker">
              </valid-connection-checker>
              <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter">
              </exception-sorter>
        </validation>
    </xa-datasource>
    
Status : Failed with indications that:
 
`2015-04-22 17:55:17,295 ERROR [org.jboss.jca.core.tx.jbossts.XAResourceRecoveryImpl] (Periodic Recovery) IJ000906: Error during crash recovery: java:jboss/PostgresXADS (Could not create connection): javax.resource.ResourceException: Could not create connection
	at org.jboss.jca.adapters.jdbc.xa.XAManagedConnectionFactory.getXAManagedConnection(XAManagedConnectionFactory.java:524)
	.....
Caused by: javax.resource.ResourceException: No XADataSourceClass supplied!
	at org.jboss.jca.adapters.jdbc.xa.XAManagedConnectionFactory.getXADataSource(XAManagedConnectionFactory.java:640)
	at org.jboss.jca.adapters.jdbc.xa.XAManagedConnectionFactory.getXAManagedConnection(XAManagedConnectionFactory.java:507)
	... 12 more`
	
	
### JTA Datasource	
	
### Persistence unit for JTA datasource
    <persistence xmlns="http://java.sun.com/xml/ns/persistence"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
                 version="2.0">
        <persistence-unit name="employee_pu">    
            <jta-data-source>java:jboss/datasources/jpaworksDS</jta-data-source>
            <properties>
                <property name="hibernate.show_sql" value="true" />
            </properties>    
        </persistence-unit>
    
    </persistence>
	

    
### Resource local datasource   
The following is a simple example

    <datasource jndi-name="java:jboss/datasources/defaultPostgresDS" pool-name="defaultPostgresDS" enabled="true"
                use-java-context="true">
        <connection-url>jdbc:postgresql://localhost:5432/default</connection-url>
        <driver>postgresql-9.4-1201.jdbc41.jar</driver>
        <security>
            <user-name>default</user-name>
            <password>default</password>
        </security>
    </datasource>
    

### Persistence unit for resource local datasource
Almost identical to jta datasource 

    <persistence xmlns="http://java.sun.com/xml/ns/persistence"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
                 version="2.0">
        <persistence-unit name="employee_pu">    
            <non-jta-data-source>java:jboss/datasources/jpaworksDS</non-jta-data-source>
            <properties>
                <property name="hibernate.show_sql" value="true" />
            </properties>    
        </persistence-unit>
    
    </persistence>

