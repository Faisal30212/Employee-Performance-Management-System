package com.besant.ems.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.besant.ems.dto.DepartmentDTO;
import com.besant.ems.entity.Department;
import com.besant.ems.repository.DepartmentRepository;
import com.besant.ems.serviceimpl.DepartmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @InjectMocks
    DepartmentServiceImpl service;

    @Mock
    DepartmentRepository repo;

    // Test Save Department
    @Test
    public void saveDepartmentTest() {

        DepartmentDTO dto = new DepartmentDTO();

        dto.setDepartmentName("Cricket Team");
        dto.setLocation("Mumbai");
        dto.setBudget(1000000.0);

        Department department = new Department();

        department.setDepartmentId(1L);
        department.setDepartmentName("Cricket Team");
        department.setLocation("Mumbai");
        department.setBudget(1000000.0);

        Mockito.when(repo.save(Mockito.any(Department.class)))
                .thenReturn(department);

        DepartmentDTO result = service.saveDepartment(dto);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getDepartmentName())
                .isEqualTo("Cricket Team");
    }

    // Test Get Department By Id
    @Test
    public void getDepartmentByIdTest() {

        Department department = new Department();

        department.setDepartmentId(1L);
        department.setDepartmentName("MS Dhoni");
        department.setLocation("Chennai");
        department.setBudget(500000.0);

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(department));

        DepartmentDTO result =
                service.getDepartmentById(1L);

        assertEquals("MS Dhoni",
                result.getDepartmentName());
    }

    // Test Get All Departments
    @Test
    public void getAllDepartmentsTest() {

        Department d1 = new Department();
        d1.setDepartmentId(1L);
        d1.setDepartmentName("MS Dhoni");

        Department d2 = new Department();
        d2.setDepartmentId(2L);
        d2.setDepartmentName("Virat Kohli");

        Mockito.when(repo.findAll())
                .thenReturn(Arrays.asList(d1, d2));

        assertEquals(2,
                service.getAllDepartments().size());
    }

    // Test Update Department
    @Test
    public void updateDepartmentTest() {

        Department department = new Department();

        department.setDepartmentId(1L);
        department.setDepartmentName("Old Team");

        DepartmentDTO dto = new DepartmentDTO();

        dto.setDepartmentName("New Team");
        dto.setLocation("Delhi");
        dto.setBudget(2000000.0);

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(department));

        Mockito.when(repo.save(Mockito.any(Department.class)))
                .thenReturn(department);

        DepartmentDTO result =
                service.updateDepartment(1L, dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Delete Department
    @Test
    public void deleteDepartmentTest() {

        Department department = new Department();

        department.setDepartmentId(1L);

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(department));

        String result =
                service.deleteDepartment(1L);

        assertEquals(
                "Department Deleted Successfully",
                result);
    }
}