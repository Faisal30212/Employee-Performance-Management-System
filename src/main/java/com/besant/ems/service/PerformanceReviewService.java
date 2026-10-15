package com.besant.ems.service;

import java.util.List;

import com.besant.ems.dto.PerformanceReviewDTO;


public interface PerformanceReviewService {

    // Used to save review
    PerformanceReviewDTO saveReview(
            PerformanceReviewDTO reviewDTO);

    // Used to fetch review by id
    PerformanceReviewDTO getReviewById(
            Long reviewId);

    // Used to fetch all reviews
    List<PerformanceReviewDTO> getAllReviews();

    // Used to update review
    PerformanceReviewDTO updateReview(
            Long reviewId,
            PerformanceReviewDTO reviewDTO);

    // Used to delete review
    String deleteReview(Long reviewId);

}