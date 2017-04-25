/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Uzzal
 */
@Entity
@Table(name = "Employee")
public class EmployeePersistence {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Long id;
    @Column(name = "EMPLOYEE_NAME")
    private String name;
    @Column(name = "EMPLOYEE_ROLE")
    private String role;
    @Column(name = "EMPLOYEE_BIO", columnDefinition = "text")
    private String bio;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "employeePersistence", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnore
//    @JsonBackReference
    private List<Skills> skills;
    @Column(name = "EMPLOYEE_IMAGE_URL")
    private String profileImage;

    public EmployeePersistence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "EmployeePersistence{" + "id=" + id + ", name=" + name + ", role=" + role + ", bio=" + bio + ", skills=" + skills + ", profileImage=" + profileImage + '}';
    }

}
