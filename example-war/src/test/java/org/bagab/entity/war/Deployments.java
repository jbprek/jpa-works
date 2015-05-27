package org.bagab.entity.war;

import org.bagab.entity.war.boundary.TestBoundary;
import org.bagab.entity.war.model.TestModel;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {
    @Deployment(name = "test-suite")
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "war-test.war")

//                .addAsWebInfResource("src/test/resources/test-jpaworks-ds.xml")
                // All classes under org.bagab.entity.war
                .addPackage(Deployments.class.getPackage())
                .addPackage(TestModel.class.getPackage())
                .addPackage(TestBoundary.class.getPackage())
                .addAsWebInfResource("test-jpaworks-ds.xml")
                .addAsWebInfResource("beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                ;
    }

}
