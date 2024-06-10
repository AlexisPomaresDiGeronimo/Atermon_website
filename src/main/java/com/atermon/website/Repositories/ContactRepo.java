package com.atermon.website.Repositories;

import com.atermon.website.Models.ContactSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<ContactSender, Long> {
    ContactSender getContactSenderByContactUsId(Long contactUsId);
}