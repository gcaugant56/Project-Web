package com.esiea.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsername(String username);
}