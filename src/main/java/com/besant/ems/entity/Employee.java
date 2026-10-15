package com.besant.ems.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * This class represents employee table in database.
 * Every employee belongs to one department.
 * One employee can have multiple reviews and projects.
 */
@Entity
@Table(name = "employee")
public class Employee {

    // Primary key of employee table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    // Stores employee name
    @NotBlank(message = "Employee name cannot be empty")
    private String employeeName;

    // Stores employee email
    @Email(message = "Enter valid email")
    private String email;

    // Stores employee designation
    @NotBlank(message = "Designation cannot be empty")
    private String designation;

    // Stores employee salary
    @NotNull(message = "Salary is required")
    private Double salary;

    // Stores employee joining date
    private LocalDate joiningDate;

    /*
     * Many employees can belong to one department.
     * Foreign key column will be department_id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    /*
     * One employee can have multiple performance reviews.
     */
    @OneToMany(mappedBy = "employee")
    private List<PerformanceReview> reviews;

    /*
     * One employee can work on multiple projects.
     * One project can contain multiple employees.
     */
    @ManyToMany
    @JoinTable(
            name = "employee_project",

            // employee_id comes from employee table
            joinColumns = @JoinColumn(name = "employee_id"),

            // project_id comes from project table
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    // Constructors

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, String email,
            String designation, Double salary,
            LocalDate joiningDate, Department department,
            List<PerformanceReview> reviews,
            List<Project> projects) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.reviews = reviews;
        this.projects = projects;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<PerformanceReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<PerformanceReview> reviews) {
        this.reviews = reviews;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    // toString method used for printing object data

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId
                + ", employeeName=" + employeeName
                + ", email=" + email
                + ", designation=" + designation
                + ", salary=" + salary
                + ", joiningDate=" + joiningDate + "]";
    }

}












/*
 * Class Purpose:
 * Stores employee details.
 * Maintains relationship with department, projects and reviews.
 * Validation annotations help prevent invalid data from entering database.
 * This entity will be mapped to employee table in MySQL.
 */