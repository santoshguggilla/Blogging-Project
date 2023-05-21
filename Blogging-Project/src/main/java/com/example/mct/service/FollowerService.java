package com.example.mct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mct.model.Follower;
import com.example.mct.model.User;
import com.example.mct.repository.FollowerRepo;

@Service
public class FollowerService {

	@Autowired
	private FollowerRepo followerRepo;
	
	public void saveFollower(User myUser, User otherUser) {


        Follower follower = new Follower(null,myUser,otherUser);

        followerRepo.save(follower);
    }
}
