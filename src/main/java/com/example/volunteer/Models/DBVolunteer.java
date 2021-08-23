package com.example.volunteer.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class DBVolunteer {
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

    @OneToMany(mappedBy = "volunteer")
    List<VSkill> vSkills;

    @OneToMany(mappedBy = "dbVolunteer")
    Set<Post> adoptedRequests;

    public DBVolunteer() {
    }

    public DBVolunteer(String username, String password, String firstname, String lastname, String bio, String dateOfBirth, String authority) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.authority = authority;
    }
    public void addRequest(Post post){
        adoptedRequests.add(post);
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

    public List<VSkill> getvSkills() {
        return vSkills;
    }

    public void setvSkills(List<VSkill> vSkills) {
        this.vSkills = vSkills;
    }

    public Set<Post> getAdoptedRequests() {
        return adoptedRequests;
    }

    public void setAdoptedRequests(Set<Post> adoptedRequests) {
        this.adoptedRequests = adoptedRequests;
    }
}
