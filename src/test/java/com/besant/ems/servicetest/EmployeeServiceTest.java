package com.besant.ems.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.besant.ems.dto.EmployeeDTO;
import com.besant.ems.entity.Department;
import com.besant.ems.entity.Employee;
import com.besant.ems.repository.DepartmentRepository;
import com.besant.ems.repository.EmployeeRepository;
import com.besant.ems.serviceimpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl service;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    DepartmentRepository departmentRepository;

    // Test Save Employee
    @Test
    public void saveEmployeeTest() {

        Department department = new Department();
        department.setDepartmentId(1L);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeName("MS Dhoni");
        dto.setEmail("dhoni@gmail.com");
        dto.setDesignation("Manager");
        dto.setSalary(100000.0);
        dto.setJoiningDate(LocalDate.now());
        dto.setDepartmentId(1L);

        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEmployeeName("MS Dhoni");
        employee.setDepartment(department);

        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(Optional.of(department));

        Mockito.when(employeeRepository.save(Mockito.any(Employee.class)))
                .thenReturn(employee);

        EmployeeDTO result = service.saveEmployee(dto);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getEmployeeName())
                .isEqualTo("MS Dhoni");
    }

    // Test Get Employee By Id
    @Test
    public void getEmployeeByIdTest() {

        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEmployeeName("Virat Kohli");

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        EmployeeDTO result = service.getEmployeeById(1L);

        assertEquals("Virat Kohli",
                result.getEmployeeName());
    }

    // Test Get All Employees
    @Test
    public void getAllEmployeesTest() {

        Employee e1 = new Employee();
        e1.setEmployeeName("MS Dhoni");

        Employee e2 = new Employee();
        e2.setEmployeeName("Virat Kohli");

        Mockito.when(employeeRepository.findAll())
                .thenReturn(Arrays.asList(e1, e2));

        assertEquals(2,
                service.getAllEmployees().size());
    }

    // Test Update Employee
    @Test
    public void updateEmployeeTest() {

        Department department = new Department();
        department.setDepartmentId(1L);

        Employee employee = new Employee();
        employee.setEmployeeId(1L);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeName("Rohit Sharma");
        dto.setEmail("rohit@gmail.com");
        dto.setDesignation("Lead");
        dto.setSalary(120000.0);
        dto.setJoiningDate(LocalDate.now());
        dto.setDepartmentId(1L);

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(Optional.of(department));

        Mockito.when(employeeRepository.save(Mockito.any(Employee.class)))
                .thenReturn(employee);

        EmployeeDTO result =
                service.updateEmployee(1L, dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Delete Employee
    @Test
    public void deleteEmployeeTest() {

        Employee employee = new Employee();
        employee.setEmployeeId(1L);

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        String result =
                service.deleteEmployee(1L);

        assertEquals(
                "Employee Deleted Successfully",
                result);
    }
}