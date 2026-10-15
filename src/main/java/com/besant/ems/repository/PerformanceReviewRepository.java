package com.besant.ems.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besant.ems.entity.PerformanceReview;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

    // Find reviews whose rating is greater than given value
    List<PerformanceReview> findByRatingGreaterThan(Double rating);

    // Find reviews between given review dates
    List<PerformanceReview> findByReviewDateBetween(LocalDate startDate,
                                                    LocalDate endDate);

}








/*
 * Interface Purpose:
 * Handles review CRUD operations.
 * Supports rating and date based searching.
 */