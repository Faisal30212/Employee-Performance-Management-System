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

import com.besant.ems.dto.PerformanceReviewDTO;
import com.besant.ems.service.PerformanceReviewService;

@RestController
@RequestMapping("/api/reviews")
public class PerformanceReviewController {

    @Autowired
    private PerformanceReviewService reviewService;

    // Used to save review
    @PostMapping
    public PerformanceReviewDTO saveReview(
            @RequestBody PerformanceReviewDTO reviewDTO) {

        return reviewService.saveReview(reviewDTO);
    }

    // Used to fetch all reviews
    @GetMapping
    public List<PerformanceReviewDTO> getAllReviews() {

        return reviewService.getAllReviews();
    }

    // Used to fetch review using id
    @GetMapping("/{reviewId}")
    public PerformanceReviewDTO getReviewById(
            @PathVariable Long reviewId) {

        return reviewService.getReviewById(reviewId);
    }

    // Used to update review
    @PutMapping("/{reviewId}")
    public PerformanceReviewDTO updateReview(
            @PathVariable Long reviewId,
            @RequestBody PerformanceReviewDTO reviewDTO) {

        return reviewService.updateReview(
                reviewId,
                reviewDTO);
    }

    // Used to delete review
    @DeleteMapping("/{reviewId}")
    public String deleteReview(
            @PathVariable Long reviewId) {

        return reviewService.deleteReview(reviewId);
    }

}







/*
 * Class Purpose:
 *
 * Handles performance review related APIs.
 *
 * APIs:
 *
 * POST    /api/reviews
 * GET     /api/reviews
 * GET     /api/reviews/{reviewId}
 * PUT     /api/reviews/{reviewId}
 * DELETE  /api/reviews/{reviewId}
 */