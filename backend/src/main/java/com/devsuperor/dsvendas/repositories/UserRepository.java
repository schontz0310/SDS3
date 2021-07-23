package com.devsuperor.dsvendas.repositories;

import com.devsuperor.dsvendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
}
