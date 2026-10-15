package com.besant.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besant.ems.entity.Employee;

/*
 * Repository used for employee database operations.
 * Contains custom query methods required for project.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employee using employee name
    List<Employee> findByEmployeeName(String employeeName);

    // Find employees by designation
    List<Employee> findByDesignation(String designation);

    // Find employee using name and salary
    List<Employee> findByEmployeeNameAndSalary(String employeeName, Double salary);

    // Find employees whose salary is greater than given amount
    List<Employee> findBySalaryGreaterThan(Double salary);

    // Find employees whose salary is between given range
    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);

    // Find employees using department name
    List<Employee> findByDepartmentDepartmentName(String departmentName);

}









/*
 * Interface Purpose:
 * Handles all employee related database operations.
 * Extends JpaRepository to get CRUD methods automatically.
 */