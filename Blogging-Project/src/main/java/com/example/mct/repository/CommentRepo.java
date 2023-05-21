package com.example.mct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mct.model.Comment;
import com.example.mct.model.Post;

public interface CommentRepo extends JpaRepository<Comment, Long>{

	List<Comment> findByPost(Post post);

}
