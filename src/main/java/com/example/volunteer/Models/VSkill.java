package com.example.volunteer.Models;

import javax.persistence.*;

@Entity
public class VSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    DBVolunteer volunteer;

    private String description;
    private String skills;
    private String field;
    private String email;

    public VSkill() {

    }

    public VSkill(DBVolunteer volunteer, String description, String skills, String field, String email) {
        this.volunteer = volunteer;
        this.description = description;
        this.skills = skills;
        this.field = field;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public DBVolunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(DBVolunteer volunteer) {
        this.volunteer = volunteer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}