package com.example.volunteer.Models;

import javax.persistence.*;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String review;
    private String reviewerName;

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
