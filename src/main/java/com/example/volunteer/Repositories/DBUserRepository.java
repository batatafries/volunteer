package com.example.volunteer.Repositories;

import com.example.volunteer.Models.DBUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserRepository extends CrudRepository<DBUser,Integer> {
    DBUser findByUsername(String username);
}
