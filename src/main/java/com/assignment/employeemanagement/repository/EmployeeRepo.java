/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.repository;

import com.assignment.employeemanagement.entity.EmployeePersistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Uzzal
 */
@Repository
public interface EmployeeRepo extends CrudRepository<EmployeePersistence, Long>{
    
}
