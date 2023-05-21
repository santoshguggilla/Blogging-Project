package com.example.mct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mct.model.AuthenticationToken;
import com.example.mct.model.User;
import com.example.mct.repository.TokenRepo;

@Service
public class TokenService {

	@Autowired
	private TokenRepo tokenRepo;

	public void saveToken(AuthenticationToken token) {
		// TODO Auto-generated method stub
		tokenRepo.save(token);
	}

	public boolean authenticate(String email, String token) {
		if (token == null && email == null) {
			return false;
		}

		AuthenticationToken authToken = tokenRepo.findFirstByToken(token);

		if (authToken == null) {
			return false;
		}

		String expectedEmail = authToken.getUser().getEmail();

		return expectedEmail.equals(email);
	}

	public void deleteToken(String token) {
		AuthenticationToken token1 = tokenRepo.findFirstByToken(token);

		tokenRepo.deleteById(token1.getTokenId());
	}

	public User findUserByToken(String token) {
		return tokenRepo.findFirstByToken(token).getUser();
	}

}
