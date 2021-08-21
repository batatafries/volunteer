package com.example.volunteer.Repositories;

import com.example.volunteer.Models.DBVolunteer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBVolunteerRepository extends CrudRepository<DBVolunteer,Integer> {
    DBVolunteer findByUsername(String username);
}
