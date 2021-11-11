package com.isdintership.epe.repository;

import com.isdintership.epe.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    Job findByJobTitle(String jobTitle);

}
