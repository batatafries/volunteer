package com.example.volunteer.Repositories;

import com.example.volunteer.Models.UserS;
import com.example.volunteer.Models.VSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VSkillRepository extends CrudRepository<VSkill,Integer> {
}
