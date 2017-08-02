package com.metadata.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metadata.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(Long id);
	
	User findByUsername(String name);

}
