package com.metadata.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metadata.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findById(Long id);

}
