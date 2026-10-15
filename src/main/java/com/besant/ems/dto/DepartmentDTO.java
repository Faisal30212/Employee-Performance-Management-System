package com.besant.ems.dto;

public class DepartmentDTO {

    private Long departmentId;
    private String departmentName;
    private String location;
    private Double budget;

    // Constructors

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long departmentId, String departmentName,
            String location, Double budget) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
        this.budget = budget;
    }

    // Getters and Setters

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

}