package com.besant.ems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besant.ems.dto.PerformanceReviewDTO;
import com.besant.ems.entity.PerformanceReview;
import com.besant.ems.exceptionHandling.PerformanceReviewNotFoundException;
import com.besant.ems.repository.PerformanceReviewRepository;
import com.besant.ems.service.PerformanceReviewService;

@Service
public class PerformanceReviewServiceImpl
        implements PerformanceReviewService {

    @Autowired
    private PerformanceReviewRepository reviewRepository;

    // Used to save review
    @Override
    public PerformanceReviewDTO saveReview(
            PerformanceReviewDTO reviewDTO) {

        PerformanceReview review = new PerformanceReview();

        review.setReviewDate(reviewDTO.getReviewDate());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());

        PerformanceReview savedReview =
                reviewRepository.save(review);

        reviewDTO.setReviewId(savedReview.getReviewId());

        return reviewDTO;
    }

    // Used to fetch review by id
    @Override
    public PerformanceReviewDTO getReviewById(
            Long reviewId) {

        PerformanceReview review =
                reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                new PerformanceReviewNotFoundException(
                        "Review not found"));

        PerformanceReviewDTO dto =
                new PerformanceReviewDTO();

        dto.setReviewId(review.getReviewId());
        dto.setReviewDate(review.getReviewDate());
        dto.setRating(review.getRating());
        dto.setComments(review.getComments());

        return dto;
    }

    // Used to fetch all reviews
    @Override
    public List<PerformanceReviewDTO> getAllReviews() {

        return reviewRepository.findAll()
                .stream()
                .map(review -> {

                    PerformanceReviewDTO dto =
                            new PerformanceReviewDTO();

                    dto.setReviewId(review.getReviewId());
                    dto.setReviewDate(review.getReviewDate());
                    dto.setRating(review.getRating());
                    dto.setComments(review.getComments());

                    return dto;

                }).toList();
    }

    // Used to update review
    @Override
    public PerformanceReviewDTO updateReview(
            Long reviewId,
            PerformanceReviewDTO reviewDTO) {

        PerformanceReview review =
                reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                new PerformanceReviewNotFoundException(
                        "Review not found"));

        review.setReviewDate(reviewDTO.getReviewDate());
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());

        reviewRepository.save(review);

        return reviewDTO;
    }

    // Used to delete review
    @Override
    public String deleteReview(Long reviewId) {

        PerformanceReview review =
                reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                new PerformanceReviewNotFoundException(
                        "Review not found"));

        reviewRepository.delete(review);

        return "Review deleted successfully";
    }

}

/*
 Purpose of this class:

 Contains review business logic.

 Handles save, fetch, update and delete operations.

 Communicates with repository layer.
*/