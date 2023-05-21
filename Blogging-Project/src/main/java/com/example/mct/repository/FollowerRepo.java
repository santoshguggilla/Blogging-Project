package com.example.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.Follower;

public interface FollowerRepo extends JpaRepository<Follower, Long>{

}
