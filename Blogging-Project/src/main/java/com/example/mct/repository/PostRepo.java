package com.example.mct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.Post;
import com.example.mct.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	
	Post findByPostId(Integer postId);

}
