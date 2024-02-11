package com.qa.baetraining.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPostWithPic;
import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.domain.UserSignUp;
import com.qa.baetraining.repo.UserPostsRepo;



@Service
public class UserPostsService {
	private UserPostsRepo repo;

	public UserPostsService(UserPostsRepo repo) {
		this.repo = repo;
	}


	
	public List<UserPostWithPic> findByUserId(long userId) {
		// Sort sort = Sort.by(Sort.Direction.DESC, "date");
		List<UserPosts> userPosts = repo.findByUser_Id(userId);
		userPosts.sort(Comparator.comparing(UserPosts::getDate).reversed());
		List<UserPostWithPic> userPostWithPics = new ArrayList<>();
		for (UserPosts userPost : userPosts) {
			UserPostWithPic userPostWithPic = new UserPostWithPic();
			// Copy properties from UserPosts to UserPosts2
			BeanUtils.copyProperties(userPost, userPostWithPic);
		
			userPostWithPic.setProfilePic(userPost.getProfilePic()); // 
		
			userPostWithPics.add(userPostWithPic);
		
		}
		return userPostWithPics;
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

