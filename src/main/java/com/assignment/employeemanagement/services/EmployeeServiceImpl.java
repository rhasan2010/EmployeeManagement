/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.services;

import com.assignment.employeemanagement.entity.EmployeePersistence;
import com.assignment.employeemanagement.entity.Skills;
import com.assignment.employeemanagement.model.Employee;
import com.assignment.employeemanagement.repository.EmployeeRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Uzzal
 */
@Service
@ComponentScan("com.assignment.employeemanagement.repository")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployeeData(Employee employee) {
        EmployeePersistence employeePersitence = new EmployeePersistence();
        employeePersitence.setName(employee.getName());
        employeePersitence.setRole(employee.getRole());
        employeePersitence.setBio(employee.getBio());
        employeePersitence.setProfileImage(employee.getProfileImage());
        List<Skills> skills = new ArrayList<Skills>();
        for (String skl : employee.getSkills()) {
            Skills skills1 = new Skills();
            skills1.setEmployeePersistence(employeePersitence);

            skills1.setSkill(skl);
            skills.add(skills1);
        }
        employeePersitence.setSkills(skills);

        employeeRepo.save(employeePersitence);
        return employee;
    }

    @Override
    public List<EmployeePersistence> getAllEmployees() {
        List<EmployeePersistence> employeePersistences = (List<EmployeePersistence>) employeeRepo.findAll();
        return employeePersistences;
    }

    @Override
    public void deleteEmployeeData(Long employeeId) {
        employeeRepo.delete(employeeId);
    }

    @Override
    public EmployeePersistence getEmployee(Long employeeId) {
        return employeeRepo.findOne(employeeId);
    }
}
