package com.besant.ems.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besant.ems.dto.EmployeeDTO;
import com.besant.ems.entity.Department;
import com.besant.ems.entity.Employee;
import com.besant.ems.exceptionHandling.EmployeeNotFoundException;
import com.besant.ems.repository.DepartmentRepository;
import com.besant.ems.repository.EmployeeRepository;
import com.besant.ems.service.EmployeeService;

/*
 * This class contains employee business logic.
 * Handles CRUD operations for employee.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // This method is used to save employee details
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Department department = departmentRepository
                .findById(employeeDTO.getDepartmentId())
                .orElseThrow(() ->
                        new RuntimeException("Department Not Found"));

        Employee employee = new Employee();

        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setJoiningDate(employeeDTO.getJoiningDate());
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmployeeId(savedEmployee.getEmployeeId());
        dto.setEmployeeName(savedEmployee.getEmployeeName());
        dto.setEmail(savedEmployee.getEmail());
        dto.setDesignation(savedEmployee.getDesignation());
        dto.setSalary(savedEmployee.getSalary());
        dto.setJoiningDate(savedEmployee.getJoiningDate());
        dto.setDepartmentId(savedEmployee.getDepartment().getDepartmentId());

        return dto;
    }

    // This method is used to fetch employee by id
    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee Not Found With Id : " + employeeId));

        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmployeeId(employee.getEmployeeId());
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmail(employee.getEmail());
        dto.setDesignation(employee.getDesignation());
        dto.setSalary(employee.getSalary());
        dto.setJoiningDate(employee.getJoiningDate());

        if (employee.getDepartment() != null) {
            dto.setDepartmentId(
                    employee.getDepartment().getDepartmentId());
        }

        return dto;
    }

    // This method is used to fetch all employees
    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employees) {

            EmployeeDTO dto = new EmployeeDTO();

            dto.setEmployeeId(employee.getEmployeeId());
            dto.setEmployeeName(employee.getEmployeeName());
            dto.setEmail(employee.getEmail());
            dto.setDesignation(employee.getDesignation());
            dto.setSalary(employee.getSalary());
            dto.setJoiningDate(employee.getJoiningDate());

            if (employee.getDepartment() != null) {
                dto.setDepartmentId(
                        employee.getDepartment().getDepartmentId());
            }

            employeeDTOList.add(dto);
        }

        return employeeDTOList;
    }

    // This method is used to update employee details
    @Override
    public EmployeeDTO updateEmployee(Long employeeId,
                                      EmployeeDTO employeeDTO) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee Not Found With Id : " + employeeId));

        Department department = departmentRepository
                .findById(employeeDTO.getDepartmentId())
                .orElseThrow(() ->
                        new RuntimeException("Department Not Found"));

        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setJoiningDate(employeeDTO.getJoiningDate());
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmployeeId(updatedEmployee.getEmployeeId());
        dto.setEmployeeName(updatedEmployee.getEmployeeName());
        dto.setEmail(updatedEmployee.getEmail());
        dto.setDesignation(updatedEmployee.getDesignation());
        dto.setSalary(updatedEmployee.getSalary());
        dto.setJoiningDate(updatedEmployee.getJoiningDate());
        dto.setDepartmentId(
                updatedEmployee.getDepartment().getDepartmentId());

        return dto;
    }

    // This method is used to delete employee
    @Override
    public String deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee Not Found With Id : " + employeeId));

        employeeRepository.delete(employee);

        return "Employee Deleted Successfully";
    }

}








/*
 * Class Purpose:
 * Handles employee related business logic.
 * Communicates with repository layer.
 * Converts DTO objects into Entity objects and vice versa.
 * Performs CRUD operations on employee table.
 */