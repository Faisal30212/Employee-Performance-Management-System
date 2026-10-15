package com.besant.ems.dto;

import java.time.LocalDate;

/*
 * DTO used for transferring employee data
 * between client and application.
 */
public class EmployeeDTO {

    private Long employeeId;
    private String employeeName;
    private String email;
    private String designation;
    private Double salary;
    private LocalDate joiningDate;
    private Long departmentId;

    // Constructors

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeName, String email,
            String designation, Double salary,
            LocalDate joiningDate, Long departmentId) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.departmentId = departmentId;
    }

    // Getters and Setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}