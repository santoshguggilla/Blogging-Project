package com.example.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findFirstByEmail(String email);

	User findByUserId(Long myId);

}
