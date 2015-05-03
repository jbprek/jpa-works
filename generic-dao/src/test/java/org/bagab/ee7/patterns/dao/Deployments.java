package org.bagab.ee7.patterns.dao;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * @author prekezes.
 */
@ArquillianSuiteDeployment
public class Deployments {
    @Deployment(name = "test-suite", order = 2)
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(WebArchive.class, "normal.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("jpaworks-ds.xml")
                .addAsWebInfResource("META-INF/persistence.xml")
                .addPackage(Deployments.class.getPackage());

    }

}
