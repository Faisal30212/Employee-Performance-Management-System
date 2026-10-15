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

import com.besant.ems.dto.ProjectDTO;
import com.besant.ems.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Used to save new project
    @PostMapping
    public ProjectDTO saveProject(
            @RequestBody ProjectDTO projectDTO) {

        return projectService.saveProject(projectDTO);
    }

    // Used to fetch all projects
    @GetMapping
    public List<ProjectDTO> getAllProjects() {

        return projectService.getAllProjects();
    }

    // Used to fetch project using id
    @GetMapping("/{projectId}")
    public ProjectDTO getProjectById(
            @PathVariable Long projectId) {

        return projectService.getProjectById(projectId);
    }

    // Used to update project details
    @PutMapping("/{projectId}")
    public ProjectDTO updateProject(
            @PathVariable Long projectId,
            @RequestBody ProjectDTO projectDTO) {

        return projectService.updateProject(
                projectId,
                projectDTO);
    }

    // Used to delete project
    @DeleteMapping("/{projectId}")
    public String deleteProject(
            @PathVariable Long projectId) {

        return projectService.deleteProject(projectId);
    }

}











/*
 * Class Purpose:
 *
 * Handles project related API requests.
 *
 * APIs:
 *
 * POST    /api/projects
 * GET     /api/projects
 * GET     /api/projects/{projectId}
 * PUT     /api/projects/{projectId}
 * DELETE  /api/projects/{projectId}
 *
 * Receives requests from Postman and
 * forwards them to service layer.
 */