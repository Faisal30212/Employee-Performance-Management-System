package com.besant.ems.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besant.ems.dto.DepartmentDTO;
import com.besant.ems.entity.Department;
import com.besant.ems.exceptionHandling.DepartmentNotFoundException;
import com.besant.ems.repository.DepartmentRepository;
import com.besant.ems.service.DepartmentService;

/*
 * Handles department business logic.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Used to save department details
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department();

        department.setDepartmentName(
                departmentDTO.getDepartmentName());

        department.setLocation(
                departmentDTO.getLocation());

        department.setBudget(
                departmentDTO.getBudget());

        Department savedDepartment =
                departmentRepository.save(department);

        DepartmentDTO dto = new DepartmentDTO();

        dto.setDepartmentId(
                savedDepartment.getDepartmentId());

        dto.setDepartmentName(
                savedDepartment.getDepartmentName());

        dto.setLocation(
                savedDepartment.getLocation());

        dto.setBudget(
                savedDepartment.getBudget());

        return dto;
    }

    // Used to fetch department by id
    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {

        Department department =
                departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department Not Found With Id : "
                                        + departmentId));

        DepartmentDTO dto = new DepartmentDTO();

        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setLocation(department.getLocation());
        dto.setBudget(department.getBudget());

        return dto;
    }

    // Used to fetch all departments
    @Override
    public List<DepartmentDTO> getAllDepartments() {

        List<Department> departments =
                departmentRepository.findAll();

        List<DepartmentDTO> departmentDTOList =
                new ArrayList<>();

        for (Department department : departments) {

            DepartmentDTO dto = new DepartmentDTO();

            dto.setDepartmentId(department.getDepartmentId());
            dto.setDepartmentName(department.getDepartmentName());
            dto.setLocation(department.getLocation());
            dto.setBudget(department.getBudget());

            departmentDTOList.add(dto);
        }

        return departmentDTOList;
    }

    // Used to update department details
    @Override
    public DepartmentDTO updateDepartment(Long departmentId,
                                          DepartmentDTO departmentDTO) {

        Department department =
                departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department Not Found With Id : "
                                        + departmentId));

        department.setDepartmentName(
                departmentDTO.getDepartmentName());

        department.setLocation(
                departmentDTO.getLocation());

        department.setBudget(
                departmentDTO.getBudget());

        Department updatedDepartment =
                departmentRepository.save(department);

        DepartmentDTO dto = new DepartmentDTO();

        dto.setDepartmentId(updatedDepartment.getDepartmentId());
        dto.setDepartmentName(updatedDepartment.getDepartmentName());
        dto.setLocation(updatedDepartment.getLocation());
        dto.setBudget(updatedDepartment.getBudget());

        return dto;
    }

    // Used to delete department
    @Override
    public String deleteDepartment(Long departmentId) {

        Department department =
                departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department Not Found With Id : "
                                        + departmentId));

        departmentRepository.delete(department);

        return "Department Deleted Successfully";
    }

}

/*
 * Class Purpose:
 * Handles department CRUD operations.
 * Converts DTO objects into Entity objects and vice versa.
 */