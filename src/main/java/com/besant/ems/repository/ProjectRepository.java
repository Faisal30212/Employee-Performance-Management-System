package com.besant.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besant.ems.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Find projects using project status
    List<Project> findByStatus(String status);

}











/*
 * Interface Purpose:
 * Handles project CRUD operations.
 * Supports project status based searching.
 */