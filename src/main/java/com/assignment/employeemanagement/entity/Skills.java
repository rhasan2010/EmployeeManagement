/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Uzzal
 */
@Entity
@Table(name = "SKILLS")
public class Skills implements Serializable{
    
    @Id
    @Column(name = "SKILL_ID")
    @GeneratedValue
    private Long id;
    @Column(name = "SKILL")
    private String skill;
    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JoinColumn(name = "EMPLOYEE_ID")
    private EmployeePersistence employeePersistence;

    public Skills() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

//    public EmployeePersistence getEmployeePersistence() {
//        return employeePersistence;
//    }

    public void setEmployeePersistence(EmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }
       
}
