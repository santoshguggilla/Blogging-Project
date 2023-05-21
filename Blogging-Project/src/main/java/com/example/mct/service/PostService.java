package com.example.mct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mct.model.Post;
import com.example.mct.model.User;
import com.example.mct.repository.PostRepo;
import com.example.mct.repository.TokenRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private TokenRepo tokenRepo;

	public void addPost(Post post) {
		 postRepo.save(post);
	}

	public List<Post> getAllPosts(String token) {
        User user = tokenRepo.findFirstByToken(token).getUser();


        List<Post> postList = postRepo.findByUser(user);

        return postList;
	}
	
}
