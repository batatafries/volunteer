package com.example.volunteer;

import org.springframework.data.repository.CrudRepository;

public interface VolunteerRepository extends CrudRepository<Volunteer,Integer>{
    public Volunteer findByUsername(String username);
}
