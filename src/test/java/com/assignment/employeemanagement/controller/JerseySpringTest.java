/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.controller;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author M.Mozadded
 */
@ContextConfiguration(locations = "classpath:META-INF/applicationContext-test.xml")
public abstract class JerseySpringTest {

    private JerseyTest _jerseyTest;

    public final WebTarget target(final String path) {
        return _jerseyTest.target(path);
    }

    @Before
    public void setupJerseyTest() throws Exception {
        _jerseyTest.setUp();
    }

    @After
    public void tearDownJerseyTest() throws Exception {
        _jerseyTest.tearDown();
    }

    @Autowired
    public void setApplicationContext(final ApplicationContext context) {
        _jerseyTest = new JerseyTest() {
            @Override
            protected Application configure() {
                ResourceConfig application = JerseySpringTest.this.configure();
                application.property("contextConfig", context);
                return application;
            }

        };
    }

    protected abstract ResourceConfig configure();
}
