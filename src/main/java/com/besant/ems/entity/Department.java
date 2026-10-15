package com.besant.ems.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// This annotation tells Spring Boot that
// this class should be treated as a database table
//Spring Boot uses it to map the class with a database table.
@Entity

// Table name in MySQL
@Table(name = "department")
public class Department {

     // Primary key of department table
    @Id

    // Auto generates id values like 1,2,3,4...
    //It automatically generates primary key values whenever a new department record is inserted
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

    private String location;

    private Double budget;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
//JPA/Hibernate needs a no-argument constructor to create objects from database records.
//JPA internally creates entity objects using reflection, so a default constructor is required.
    public Department() {

}

// Parameterized constructor
public Department(Long departmentId, String departmentName, String location, Double budget) {
    this.departmentId = departmentId;
    this.departmentName = departmentName;
    this.location = location;
    this.budget = budget;
}

//toString() is used to convert an object into a readable String.
@Override
public String toString() {
    return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
            + ", location=" + location + ", budget=" + budget + "]";
}

// One department can have many employees
@OneToMany(mappedBy = "department")
private List<Employee> employees;

}










// Why did you create getters and setters?

// The fields are private, so they cannot be accessed directly from other classes. Getters are used to read data and setters are used to update data while maintaining encapsulation.