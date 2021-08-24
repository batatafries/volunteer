package com.example.volunteer.Repositories;

import com.example.volunteer.Models.Reviews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DBReviewsRepository extends CrudRepository<Reviews,Integer> {

}
