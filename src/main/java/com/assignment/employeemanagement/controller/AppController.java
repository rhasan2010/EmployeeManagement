/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.controller;

import com.assignment.employeemanagement.entity.EmployeePersistence;
import com.assignment.employeemanagement.model.AllEmployees;
import com.assignment.employeemanagement.model.Employee;
import com.assignment.employeemanagement.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Uzzal
 */
@RestController
@RequestMapping("/")
@EnableWebMvc
@ComponentScan("com.assignment.employeemanagement.services")
public class AppController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/populateemployeelist", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Employee> requestToGetJSONDataFromServer() throws IOException {
        InputStream data;
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeesList = null;

        try {
            data = new URL("https://sys4.open-web.nl/employees.json").openStream();
            AllEmployees allEmployees = mapper.readValue(data, AllEmployees.class);
            employeesList = allEmployees.getEmployees();

        } catch (MalformedURLException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeesList;
    }

    @RequestMapping(value = "/saveemployeelocally", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }

        employee = employeeService.saveEmployeeData(employee);
        httpHeaders.add("Data added localy for Employee: ", String.valueOf(employee.getName()));

        return new ResponseEntity<Employee>(employee, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/listofemployees", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<EmployeePersistence>> getEmployeesList() {
        HttpHeaders httpHeaders = new HttpHeaders();

        List<EmployeePersistence> employees = employeeService.getAllEmployees();
        if (employees == null) {
            return new ResponseEntity<List<EmployeePersistence>>(HttpStatus.NOT_FOUND);
        }
        httpHeaders.add("Number Of Records Found", String.valueOf(employees.size()));
        return new ResponseEntity<List<EmployeePersistence>>(employees, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EmployeePersistence> deleteEmployee(@PathVariable("id") Long employeeId) {
        HttpHeaders httpHeaders = new HttpHeaders();

        EmployeePersistence employeePersistence = employeeService.getEmployee(employeeId);
        if (employeePersistence == null) {
            return new ResponseEntity<EmployeePersistence>(HttpStatus.NOT_FOUND);
        }

        employeeService.deleteEmployeeData(employeeId);

        httpHeaders.add("Employee Deleted - ", String.valueOf(employeeId));
        return new ResponseEntity<EmployeePersistence>(employeePersistence, httpHeaders, HttpStatus.NO_CONTENT);
    }

}
