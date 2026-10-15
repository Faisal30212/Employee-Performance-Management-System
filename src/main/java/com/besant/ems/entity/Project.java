package com.besant.ems.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/*
 * This class represents project table in database.
 * One project can have multiple employees.
 */
@Entity
@Table(name = "project")
public class Project {

    // Primary key of project table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    // Storing project name,client name, start date, end date and project status
    private String projectName;

    private String clientName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    /*
     * Many projects can have many employees.
     * Employee class will own this relationship.
     */
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    // Constructors

    public Project() {
    }

    public Project(Long projectId, String projectName, String clientName,
                   LocalDate startDate, LocalDate endDate,
                   String status, List<Employee> employees) {

        this.projectId = projectId;
        this.projectName = projectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employees = employees;
    }

    // Getters and Setters

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // toString method used for printing object data

    @Override
    public String toString() {
        return "Project [projectId=" + projectId +
                ", projectName=" + projectName +
                ", clientName=" + clientName +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status + "]";
    }

}







/*
 * Class Purpose:
 * Stores project details.
 * Maintains many-to-many relationship with employees.
 * Used for project allocation and project tracking.
 */