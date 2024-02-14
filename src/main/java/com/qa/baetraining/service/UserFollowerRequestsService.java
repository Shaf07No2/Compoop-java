package com.qa.baetraining.service;

import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.repo.UserFollowerRequestsRepo;
import com.qa.baetraining.repo.UserFriendRepo;

@Service
public class UserFollowerRequestsService {
	private UserFollowerRequestsRepo repo;

	public UserFollowerRequestsService(UserFollowerRequestsRepo repo) {
		this.repo = repo;
	}
	
	public List<UserInformationSchema> findRequestsByUserId(long userId) {
		return repo.findAllRequestsByUserId(userId);
	}

	@Transactional
    public int sendFriendRequestByUserId(long userId, long requesterUserId){
        try {
			this.repo.sendFriendRequestByUserId(userId, requesterUserId);
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
    }

	// public List<UserPosts> findAllFriendPostsByUserId(long userId) {
	// 	List<UserPosts> userPosts = repo.findAllFriendPostsByUserId(userId);userPosts.sort(Comparator.comparing(UserPosts::getDate).reversed());
	// 	return userPosts;
	// }

	// public List<UserInformationSchema> findAllFriendsByUserId(long userId) {
	// 	return repo.findAllFriendsByUserId(userId);
	// }
	// public UserInformationSchema findAFriendByUserId(Long userId, Long friendId) {
	// 	return repo.findAFriendByUserId(userId, friendId);
	// }

	// public Boolean existsFriendByUserId(Long userId, Long friendId) {
	// 	return repo.existsFriendByUserId(userId, friendId);
	// }

}

