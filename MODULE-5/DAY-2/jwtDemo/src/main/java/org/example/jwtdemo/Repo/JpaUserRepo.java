package org.example.jwtdemo.Repo;

import org.example.jwtdemo.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepo extends JpaRepository<JpaUser, Long> {
    JpaUser findByUsername(String username);
}
