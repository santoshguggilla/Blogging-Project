package com.example.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.AuthenticationToken;

public interface TokenRepo extends JpaRepository<AuthenticationToken, Long>{

	AuthenticationToken findFirstByToken(String token);

}
