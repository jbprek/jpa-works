Oracle ojdbc7 manual maven artifact install
===========================================

How to install manually ojdbc7.jar into local maven repository.

Run the following command:
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar -Dfile=ojdbc7.jar -DgeneratePom=true


Mave depedency
==============
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc7</artifactId>
    <version>12.1.0.1</version>
</dependency>
