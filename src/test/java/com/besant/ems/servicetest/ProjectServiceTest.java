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

import com.besant.ems.dto.ProjectDTO;
import com.besant.ems.entity.Project;
import com.besant.ems.repository.ProjectRepository;
import com.besant.ems.serviceimpl.ProjectServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @InjectMocks
    ProjectServiceImpl service;

    @Mock
    ProjectRepository repo;

    // Test Save Project
    @Test
    public void saveProjectTest() {

        ProjectDTO dto = new ProjectDTO();

        dto.setProjectName("IPL Analytics System");
        dto.setClientName("BCCI");
        dto.setStartDate(LocalDate.now());
        dto.setEndDate(LocalDate.now());
        dto.setStatus("Active");

        Project project = new Project();

        project.setProjectId(1L);
        project.setProjectName("IPL Analytics System");

        Mockito.when(repo.save(Mockito.any(Project.class)))
                .thenReturn(project);

        ProjectDTO result = service.saveProject(dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Get Project By Id
    @Test
    public void getProjectByIdTest() {

        Project project = new Project();

        project.setProjectId(1L);
        project.setProjectName("IPL Analytics System");

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(project));

        ProjectDTO result = service.getProjectById(1L);

        assertEquals("IPL Analytics System",
                result.getProjectName());
    }

    // Test Get All Projects
    @Test
    public void getAllProjectsTest() {

        Project p1 = new Project();
        p1.setProjectId(1L);

        Project p2 = new Project();
        p2.setProjectId(2L);

        Mockito.when(repo.findAll())
                .thenReturn(Arrays.asList(p1, p2));

        assertEquals(2,
                service.getAllProjects().size());
    }

    // Test Update Project
    @Test
    public void updateProjectTest() {

        Project project = new Project();
        project.setProjectId(1L);

        ProjectDTO dto = new ProjectDTO();

        dto.setProjectName("Cricket Performance Tracker");
        dto.setClientName("BCCI");
        dto.setStartDate(LocalDate.now());
        dto.setEndDate(LocalDate.now());
        dto.setStatus("Completed");

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(project));

        Mockito.when(repo.save(Mockito.any(Project.class)))
                .thenReturn(project);

        ProjectDTO result =
                service.updateProject(1L, dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Delete Project
    @Test
    public void deleteProjectTest() {

        Project project = new Project();
        project.setProjectId(1L);

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(project));

        String result =
                service.deleteProject(1L);

        assertEquals(
                "Project deleted successfully",
                result);
    }
}