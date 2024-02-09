package com.qa.baetraining.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.domain.UserSignUp;
import com.qa.baetraining.repo.UserPostsRepo;
// import com.qa.baetraining.exceptions.UserNotFound;
import com.qa.baetraining.repo.UserRepo;

@Service
public class UserPostsService {
	private UserPostsRepo repo;

	public UserPostsService(UserPostsRepo repo) {
		this.repo = repo;
	}
	
	public List<UserPosts> findByUserId(long userId) {
		return repo.findByUser_Id(userId);
	}

	@Transactional
	public int createPost(UserPosts userPosts) {
		// String role = "USER";
		try {
		
			this.repo.createPost(userPosts.getTitle(), userPosts.getDescription(), userPosts.getPicture(), userPosts.getUser().getId());
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
	}
}

