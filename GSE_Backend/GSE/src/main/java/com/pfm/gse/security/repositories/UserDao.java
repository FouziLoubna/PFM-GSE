package com.pfm.gse.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfm.gse.security.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}