package com.besant.ems.service;

import java.util.List;

import com.besant.ems.dto.ProjectDTO;

public interface ProjectService {

    // Used to save project
    ProjectDTO saveProject(ProjectDTO projectDTO);

    // Used to fetch project by id
    ProjectDTO getProjectById(Long projectId);

    // Used to fetch all projects
    List<ProjectDTO> getAllProjects();

    // Used to update project details
    ProjectDTO updateProject(Long projectId,
                             ProjectDTO projectDTO);

    // Used to delete project
    String deleteProject(Long projectId);

}