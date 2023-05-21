package com.example.mct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mct.model.Comment;
import com.example.mct.model.Post;
import com.example.mct.model.User;
import com.example.mct.repository.PostRepo;
import com.example.mct.service.CommentService;
import com.example.mct.service.TokenService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
	TokenService authService;
	@Autowired
	PostRepo postRepo;

	@PostMapping("/{postId}")
	ResponseEntity<String> addComment(@RequestBody Comment comment, @RequestParam String email,
			@RequestParam String token, @PathVariable Integer postId) {

		HttpStatus status;
		String msg = "";
		Post post = postRepo.findByPostId(postId);
		if (authService.authenticate(email, token) && post != null) {
			User user = authService.findUserByToken(token);
			comment.setUser(user);
			comment.setPost(post);
			commentService.addComment(comment);
			msg = " Comment posted successfully";
			status = HttpStatus.OK;
		} else {
			msg = "Invalid user";
			status = HttpStatus.FORBIDDEN;
		}

		return new ResponseEntity<String>(msg, status);

	}

	@GetMapping("/getAllComments/{postId}")
	ResponseEntity<List<Comment>> getAllComments(@RequestParam String email,
			@RequestParam String token, @PathVariable Integer postId){
		HttpStatus status;
        List<Comment> commentList = null;
		Post post = postRepo.findByPostId(postId);
		if (authService.authenticate(email, token) && post != null) {
			commentList=commentService.findByPost(post);
		     status = HttpStatus.OK;
        }
        else
        {

            status = HttpStatus.FORBIDDEN;
        }
		return new ResponseEntity<List<Comment>>(commentList,status);
	}
}
