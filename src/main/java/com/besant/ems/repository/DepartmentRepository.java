package com.besant.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besant.ems.entity.Department;

/*
 * Repository used for department database operations.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}









/*
 * Interface Purpose:
 * Handles department CRUD operations.
 */