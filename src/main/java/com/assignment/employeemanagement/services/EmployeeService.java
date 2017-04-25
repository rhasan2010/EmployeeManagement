/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.services;

import com.assignment.employeemanagement.entity.EmployeePersistence;
import com.assignment.employeemanagement.model.Employee;
import java.util.List;

/**
 *
 * @author Uzzal
 */
public interface EmployeeService {

    Employee saveEmployeeData(Employee employee);

    List<EmployeePersistence> getAllEmployees();
    
    EmployeePersistence getEmployee(Long employeeId);
    
    void deleteEmployeeData(Long employeeId);
}
