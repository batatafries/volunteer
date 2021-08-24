package com.example.volunteer.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DBUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String bio;
    private String dateOfBirth;
    private String authority;

    @OneToMany(mappedBy = "user")
        List<Post> post;

    @OneToMany(mappedBy = "reviewedUser")
    List<Reviews> userReviews;

    public DBUser() {
    }

    public DBUser(String username, String password, String firstname, String lastname, String bio, String dateOfBirth, String authority) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.authority = authority;
    }
    public void addReview(Reviews review) {
        userReviews.add(review);
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Reviews> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<Reviews> userReviews) {
        this.userReviews = userReviews;
    }
}
