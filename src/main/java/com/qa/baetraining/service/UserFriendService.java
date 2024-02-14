package com.qa.baetraining.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	public List<UserInformationSchema> findUsersByName(String firstName) {
		return repo.findUsersByName(firstName);
	}

	public List<UserPosts> findAllFriendPostsByUserId(long userId) {
		List<UserPosts> userPosts = repo.findAllFriendPostsByUserId(userId);userPosts.sort(Comparator.comparing(UserPosts::getDate).reversed());
		return userPosts;
	}

	public List<UserInformationSchema> findAllFriendsByUserId(long userId) {
		return repo.findAllFriendsByUserId(userId);
	}
	public UserInformationSchema findAFriendByUserId(Long userId, Long friendId) {
		return repo.findAFriendByUserId(userId, friendId);
	}

	public Boolean existsFriendByUserId(Long userId, Long friendId) {
		return repo.existsFriendByUserId(userId, friendId);
	}

}

