package com.besant.ems.dto;

import java.time.LocalDate;


 //DTO used for review data transfer
 
public class PerformanceReviewDTO {

    private Long reviewId;
    private int rating;
    private String comments;
    private LocalDate reviewDate;
    private String feedback;
    private Long employeeId;

    // Constructors

    public PerformanceReviewDTO() {
    }

    public PerformanceReviewDTO(Long reviewId, int rating,
            String comments, LocalDate reviewDate,
            String feedback, Long employeeId) {

        this.reviewId = reviewId;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = reviewDate;
        this.feedback = feedback;
        this.employeeId = employeeId;
    }

    // Getters and Setters

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

}