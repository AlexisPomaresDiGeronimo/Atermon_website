package com.atermon.website.Repositories;

import com.atermon.website.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {
    Staff getStaffBystaffId(Long staffId);
}
