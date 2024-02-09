package com.qa.baetraining.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.repo.UserFriendRepo;

@Service
public class UserFriendService {
	private UserFriendRepo repo;

	public UserFriendService(UserFriendRepo repo) {
		this.repo = repo;
	}
	
	public List<UserPosts> findAllFriendPostsByUserId(long userId) {
		return repo.findAllFriendPostsByUserId(userId);
	}

	public List<UserInformationSchema> findAllFriendsByUserId(long userId) {
		return repo.findAllFriendsByUserId(userId);
	}
}

