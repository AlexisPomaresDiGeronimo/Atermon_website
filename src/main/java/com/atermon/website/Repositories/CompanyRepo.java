package com.atermon.website.Repositories;

import com.atermon.website.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
    Company getCompanyBycompanyId(Long companyId);
}