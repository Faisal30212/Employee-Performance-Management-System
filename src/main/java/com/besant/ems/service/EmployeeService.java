package com.besant.ems.service;

import java.util.List;

import com.besant.ems.dto.EmployeeDTO;


public interface EmployeeService {

    // Used to save employee details
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    // Used to fetch employee using id
    EmployeeDTO getEmployeeById(Long employeeId);

    // Used to fetch all employees
    List<EmployeeDTO> getAllEmployees();

    // Used to update employee details
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

    // Used to delete employee
    String deleteEmployee(Long employeeId);

}