package com.example.mct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mct.model.Comment;
import com.example.mct.model.Post;
import com.example.mct.repository.CommentRepo;

@Service
public class CommentService {

	@Autowired
	private CommentRepo commentRepo;

	public String addComment(Comment comment) {
		Comment rComment = commentRepo.save(comment);
        if(rComment == null)
        {
            return "Comment not saved...!";
        }
        else
        {
            return "Comment saved...!";
        }
	}

	public List<Comment> findByPost(Post post) {
		// TODO Auto-generated method stub
		return commentRepo.findByPost(post);
	}
	
	
}
