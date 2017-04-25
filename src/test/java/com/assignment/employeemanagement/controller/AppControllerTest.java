/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.controller;

import com.assignment.employeemanagement.entity.EmployeePersistence;
import com.assignment.employeemanagement.model.Employee;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Uzzal
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/applicationContext-test.xml"})
@ActiveProfiles("unit-test")
@WebAppConfiguration
public class AppControllerTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of requestToGetJSONDataFromServer method, of class AppController.
     */
//    @Test
//    public void testRequestToGetJSONDataFromServer() throws Exception {
//        System.out.println("requestToGetJSONDataFromServer");
//        AppController instance = new AppController();
//        List<Employee> expResult = null;
//        List<Employee> result = instance.requestToGetJSONDataFromServer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of saveEmployee method, of class AppController.
     */
//    @Test
//    public void testSaveEmployee() {
//        System.out.println("saveEmployee");
//        Employee employee = null;
//        AppController instance = new AppController();
//        ResponseEntity<Employee> expResult = null;
//        ResponseEntity<Employee> result = instance.saveEmployee(employee);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getEmployeesList method, of class AppController.
     */
//    @Test
//    public void testGetEmployeesList() {
//        System.out.println("getEmployeesList");
//        AppController instance = new AppController();
//        ResponseEntity<List<EmployeePersistence>> expResult = null;
//        ResponseEntity<List<EmployeePersistence>> result = instance.getEmployeesList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteEmployee method, of class AppController.
     */
//    @Test
//    public void testDeleteEmployee() {
//        System.out.println("deleteEmployee");
//        Long employeeId = null;
//        AppController instance = new AppController();
//        ResponseEntity<EmployeePersistence> expResult = null;
//        ResponseEntity<EmployeePersistence> result = instance.deleteEmployee(employeeId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
