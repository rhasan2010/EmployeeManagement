/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.controller;

import com.assignment.employeemanagement.services.EmployeeService;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Uzzal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/applicationContext-test.xml"})
@ActiveProfiles("unit-test")
@WebAppConfiguration
public class AppControllerTest extends JerseySpringTest {

    @Autowired
    EmployeeService employeeService;
    private MockMvc mockMvc;

    public AppControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        reset(employeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(new AppController()).build();
    }

    @Test
    public void justAtest() {
        Assert.assertEquals(2, 2);
    }

    @After
    public void tearDown() {
    }

    @Override
    protected ResourceConfig configure() {
        return new ResourceConfig(AppController.class);
    }
}
