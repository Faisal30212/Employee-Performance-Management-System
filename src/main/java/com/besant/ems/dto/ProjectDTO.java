package com.besant.ems.dto;

import java.time.LocalDate;

/*
 * DTO used for project data transfer.
 */
public class ProjectDTO {

    private Long projectId;
    private String projectName;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    // Constructors

    public ProjectDTO() {
    }

    public ProjectDTO(Long projectId, String projectName,
            String clientName, LocalDate startDate,
            LocalDate endDate, String status) {

        this.projectId = projectId;
        this.projectName = projectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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

}