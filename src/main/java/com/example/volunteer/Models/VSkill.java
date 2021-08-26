package com.example.volunteer.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    DBVolunteer volunteer;

    private String description;
    private String field;
    private String email;
    private String phone;

    @CreationTimestamp
    Date createdAt;

    public VSkill() {

    }

    public VSkill(DBVolunteer volunteer, String description, String field, String email , String phone) {
        this.volunteer = volunteer;
        this.description = description;
        this.field = field;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
