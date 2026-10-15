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

import com.besant.ems.dto.PerformanceReviewDTO;
import com.besant.ems.entity.PerformanceReview;
import com.besant.ems.repository.PerformanceReviewRepository;
import com.besant.ems.serviceimpl.PerformanceReviewServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PerformanceReviewServiceTest {

    @InjectMocks
    PerformanceReviewServiceImpl service;

    @Mock
    PerformanceReviewRepository repo;

    // Test Save Review
    @Test
    public void saveReviewTest() {

        PerformanceReviewDTO dto = new PerformanceReviewDTO();

        dto.setReviewDate(LocalDate.now());
        dto.setRating(5);
        dto.setComments("Excellent Performance By MS Dhoni");

        PerformanceReview review = new PerformanceReview();

        review.setReviewId(1L);
        review.setReviewDate(LocalDate.now());
        review.setRating(5);
        review.setComments("Excellent Performance By MS Dhoni");

        Mockito.when(repo.save(Mockito.any(PerformanceReview.class)))
                .thenReturn(review);

        PerformanceReviewDTO result =
                service.saveReview(dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Get Review By Id
    @Test
    public void getReviewByIdTest() {

        PerformanceReview review = new PerformanceReview();

        review.setReviewId(1L);
        review.setRating(5);
        review.setComments("Virat Kohli Review");

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(review));

        PerformanceReviewDTO result =
                service.getReviewById(1L);

        assertEquals("Virat Kohli Review",
                result.getComments());
    }

    // Test Get All Reviews
    @Test
    public void getAllReviewsTest() {

        PerformanceReview r1 = new PerformanceReview();
        r1.setReviewId(1L);

        PerformanceReview r2 = new PerformanceReview();
        r2.setReviewId(2L);

        Mockito.when(repo.findAll())
                .thenReturn(Arrays.asList(r1, r2));

        assertEquals(2,
                service.getAllReviews().size());
    }

    // Test Update Review
    @Test
    public void updateReviewTest() {

        PerformanceReview review = new PerformanceReview();

        review.setReviewId(1L);

        PerformanceReviewDTO dto =
                new PerformanceReviewDTO();

        dto.setReviewDate(LocalDate.now());
        dto.setRating(4);
        dto.setComments("Updated Review");

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(review));

        Mockito.when(repo.save(Mockito.any(PerformanceReview.class)))
                .thenReturn(review);

        PerformanceReviewDTO result =
                service.updateReview(1L, dto);

        Assertions.assertThat(result).isNotNull();
    }

    // Test Delete Review
    @Test
    public void deleteReviewTest() {

        PerformanceReview review =
                new PerformanceReview();

        review.setReviewId(1L);

        Mockito.when(repo.findById(1L))
                .thenReturn(Optional.of(review));

        String result =
                service.deleteReview(1L);

        assertEquals(
                "Review deleted successfully",
                result);
    }
}