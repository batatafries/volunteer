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
    private String time;
    private Integer phone;

    @CreationTimestamp
    Date createdAt;

    @ManyToOne
    DBUser user;

    public Post() {
    }

    public Post(String body, DBUser user) {
        this.body = body;
        this.user = user;
    }


    public Post(String body, String field, String date, String time, Integer phone, DBUser user) {
        this.user = user;
        this.body = body;
        this.field = field;
        this.date = date;
        this.time = time;
        this.phone = phone;
    }

    public DBUser getUser() {
        return user;
    }

    public void setUser(DBUser user) {
        this.user = user;
    }

    public String getTime() {
        return time;
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

    public void setTime(String time) {
        this.time = time;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getPhone() {
        return phone;
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

}
