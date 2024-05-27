package com.atermon.website.Repositories;
import com.atermon.website.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {
    Job getJobsByJobId(Long jobId);
}