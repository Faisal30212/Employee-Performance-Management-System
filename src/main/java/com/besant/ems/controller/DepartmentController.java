package com.besant.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.besant.ems.dto.DepartmentDTO;
import com.besant.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Used to save new department
    @PostMapping
    public DepartmentDTO saveDepartment(
            @RequestBody DepartmentDTO departmentDTO) {

        return departmentService.saveDepartment(departmentDTO);
    }

    // Used to fetch all departments
    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {

        return departmentService.getAllDepartments();
    }

    // Used to fetch department using id
    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartmentById(
            @PathVariable Long departmentId) {

        return departmentService.getDepartmentById(departmentId);
    }

    // Used to update department details
    @PutMapping("/{departmentId}")
    public DepartmentDTO updateDepartment(
            @PathVariable Long departmentId,
            @RequestBody DepartmentDTO departmentDTO) {

        return departmentService.updateDepartment(
                departmentId,
                departmentDTO);
    }

    // Used to delete department
    @DeleteMapping("/{departmentId}")
    public String deleteDepartment(
            @PathVariable Long departmentId) {

        return departmentService.deleteDepartment(departmentId);
    }

}








/*
 * Class Purpose:
 *
 * Handles department related API requests.
 *
 * APIs:
 *
 * POST    /api/departments
 * GET     /api/departments
 * GET     /api/departments/{departmentId}
 * PUT     /api/departments/{departmentId}
 * DELETE  /api/departments/{departmentId}
 *
 * Receives requests from Postman and
 * forwards them to service layer.
 */