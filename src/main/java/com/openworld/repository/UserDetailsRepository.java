package com.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openworld.domain.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
