package com.atermon.website.Repositories;

import com.atermon.website.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
