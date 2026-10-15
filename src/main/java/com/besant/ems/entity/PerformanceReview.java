package com.besant.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * This class stores employee performance review details.
 * One employee can have multiple reviews.
 */
@Entity
@Table(name = "performance_review")
public class PerformanceReview {

    // Primary key of review table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    // Stores employee rating
    private int rating;

    // Stores manager comments
    private String comments;

    // Stores review date
    private LocalDate reviewDate;

    // Stores feedback
    private String feedback;

    /*
     * Many reviews can belong to one employee.
     * Foreign key will be employee_id.
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors

    public PerformanceReview() {
    }

    public PerformanceReview(Long reviewId, int rating,
            String comments, LocalDate reviewDate,
            String feedback, Employee employee) {

        this.reviewId = reviewId;
        this.rating = rating;
        this.comments = comments;
        this.reviewDate = reviewDate;
        this.feedback = feedback;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // toString method used for printing object data

    @Override
    public String toString() {
        return "PerformanceReview [reviewId=" + reviewId
                + ", rating=" + rating
                + ", comments=" + comments
                + ", reviewDate=" + reviewDate
                + ", feedback=" + feedback + "]";
    }
}








/*
 * Class Purpose:
 * Stores employee performance reviews.
 * Maintains review history for employees.
 * Helps managers track employee performance and ratings.
 */