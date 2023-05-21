package com.example.mct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mct.model.Following;
import com.example.mct.model.User;
import com.example.mct.repository.FollowingRepo;

@Service
public class FollowingService {

	@Autowired
	private FollowingRepo followingRepo;
	
	public void saveFollowing(User myUser, User otherUser) {
        Following followingRecord = new Following(null,myUser,otherUser);
        followingRepo.save(followingRecord);
    }
}
