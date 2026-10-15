package com.besant.ems.service;

import java.util.List;

import com.besant.ems.dto.DepartmentDTO;


public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long departmentId);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(Long departmentId,
                                   DepartmentDTO departmentDTO);

    String deleteDepartment(Long departmentId);

}