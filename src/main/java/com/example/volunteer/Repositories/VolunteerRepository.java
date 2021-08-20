package com.example.volunteer.Repositories;

import com.example.volunteer.Models.Volunteer;
import org.springframework.data.repository.CrudRepository;

public interface VolunteerRepository extends CrudRepository<Volunteer,Integer>{
    Volunteer findByUsername(String username);
}
