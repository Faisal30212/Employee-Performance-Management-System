package com.besant.ems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besant.ems.dto.ProjectDTO;
import com.besant.ems.entity.Project;
import com.besant.ems.exceptionHandling.ProjectNotFoundException;
import com.besant.ems.repository.ProjectRepository;
import com.besant.ems.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Used to save project details
    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {

        Project project = new Project();

        project.setProjectName(projectDTO.getProjectName());
        project.setClientName(projectDTO.getClientName());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(projectDTO.getStatus());

        Project savedProject = projectRepository.save(project);

        projectDTO.setProjectId(savedProject.getProjectId());

        return projectDTO;
    }

    // Used to fetch project by id
    @Override
    public ProjectDTO getProjectById(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found"));

        ProjectDTO dto = new ProjectDTO();

        dto.setProjectId(project.getProjectId());
        dto.setProjectName(project.getProjectName());
        dto.setClientName(project.getClientName());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setStatus(project.getStatus());

        return dto;
    }

    // Used to fetch all projects
    @Override
    public List<ProjectDTO> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(project -> {

                    ProjectDTO dto = new ProjectDTO();

                    dto.setProjectId(project.getProjectId());
                    dto.setProjectName(project.getProjectName());
                    dto.setClientName(project.getClientName());
                    dto.setStartDate(project.getStartDate());
                    dto.setEndDate(project.getEndDate());
                    dto.setStatus(project.getStatus());

                    return dto;

                }).toList();
    }

    // Used to update project details
    @Override
    public ProjectDTO updateProject(Long projectId,
                                    ProjectDTO projectDTO) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found"));

        project.setProjectName(projectDTO.getProjectName());
        project.setClientName(projectDTO.getClientName());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(projectDTO.getStatus());

        projectRepository.save(project);

        return projectDTO;
    }

    // Used to delete project
    @Override
    public String deleteProject(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found"));

        projectRepository.delete(project);

        return "Project deleted successfully";
    }

}









/*
 Purpose of this class:

 Contains business logic related to projects.

 Receives requests from controller.

 Performs save, get, update and delete operations.

 Communicates with ProjectRepository.
*/