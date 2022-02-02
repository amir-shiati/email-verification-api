package com.amirshiati.Emailverification.repository;

import com.amirshiati.Emailverification.entity.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    EmailModel findFirstByAddressOrderBySendTimeDesc(String address);
}
