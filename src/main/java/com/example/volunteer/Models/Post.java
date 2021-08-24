package com.example.volunteer.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String body;
    private String field;
    private String date;
    private String phone;
    private String status;
    @CreationTimestamp
    Date createdAt;

    @ManyToOne
    DBUser user;

    @ManyToOne
    DBVolunteer dbVolunteer;

    public Post() {
    }

    public Post(String body, DBUser user) {
        this.body = body;
        this.user = user;
    }

    public Post(String body, String field, String date, String phone, DBUser user , String status) {
        this.user = user;
        this.body = body;
        this.field = field;
        this.date = date;
        this.phone = phone;
        this.status = status;
    }

    public DBUser getUser() {
        return user;
    }

    public void setUser(DBUser user) {
        this.user = user;
    }

    public String getField() {
        return field;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBody() {
        return body;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DBVolunteer getDbVolunteer() {
        return dbVolunteer;
    }

    public void setDbVolunteer(DBVolunteer dbVolunteer) {
        this.dbVolunteer = dbVolunteer;
    }
}
