package com.openworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openworld.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByLogin(String login);
}
