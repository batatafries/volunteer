package com.example.volunteer.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String review;
    private String reviewerName;
    @CreationTimestamp
    Date createdAt;

    @ManyToOne
    DBVolunteer reviewedVolunteer;

    @ManyToOne
    DBUser reviewedUser;

    public Reviews() {
    }

    public Reviews(String review, String reviewerName) {
        this.review = review;
        this.reviewerName = reviewerName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public DBVolunteer getReviewedVolunteer() {
        return reviewedVolunteer;
    }

    public void setReviewedVolunteer(DBVolunteer reviewedVolunteer) {
        this.reviewedVolunteer = reviewedVolunteer;
    }

    public DBUser getReviewedUser() {
        return reviewedUser;
    }

    public void setReviewedUser(DBUser reviewedUser) {
        this.reviewedUser = reviewedUser;
    }
}
