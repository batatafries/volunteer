package com.example.volunteer.Repositories;

import com.example.volunteer.Models.UserS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserS,Integer> {
    UserS findByUsername(String username);
}
