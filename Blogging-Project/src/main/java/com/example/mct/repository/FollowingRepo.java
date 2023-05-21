package com.example.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.Following;

public interface FollowingRepo extends JpaRepository<Following, Long>{
	Long countByUser_userId(long userId);
}
