package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}

