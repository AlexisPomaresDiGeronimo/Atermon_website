package com.atermon.website.Repositories;

import com.atermon.website.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
        Candidate getCandidatesBycandidateId(Long candidateId);
}