package com.example.volunteer.Repositories;

import com.example.volunteer.Models.Reviews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBReviewsRepository extends CrudRepository<Reviews,Integer> {

}
