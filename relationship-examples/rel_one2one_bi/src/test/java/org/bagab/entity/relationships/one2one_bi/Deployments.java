package org.bagab.entity.relationships.one2one_bi;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {

    static  File[] entitiesCode = Maven.resolver().resolve("org.bagab.jpa:example-relationships:1.0-SNAPSHOT").withTransitivity().asFile();

    @Deployment(name = "test-suite", order = 1)
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "normal.war")
                .addAsLibraries(entitiesCode)
                .addAsWebInfResource(new File("src/test/resources/beans.xml"))
                .addAsWebInfResource(new File("src/test/resources/jpaworks-ds.xml"))
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addPackage(Deployments.class.getPackage())
                ;
    }

}
