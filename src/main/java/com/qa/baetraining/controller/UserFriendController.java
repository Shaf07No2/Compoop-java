package com.qa.baetraining.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import io.github.cdimascio.dotenv.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.domain.UserSignUp;
import com.qa.baetraining.security.JwtTokenUtil;
import com.qa.baetraining.service.UserFriendService;
import com.qa.baetraining.service.UserPostsService;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
@RestController
public class UserFriendController {

	public UserFriendService service;
	
	public UserFriendController(UserFriendService service) {
		this.service = service;
	}

	Dotenv dotenv = Dotenv.load();

	@Autowired
	private JwtTokenUtil jwtTokenUtil; 

	@GetMapping("/search/{firstName}")
	public ResponseEntity<List<UserInformationSchema>> findUsersByName(@PathVariable("firstName") String firstName, @RequestHeader("Authorization") String authHeader) {
		try {
			List<UserInformationSchema> userResults = service.findUsersByName(firstName);
			if (userResults == null) {
				return new ResponseEntity<List<UserInformationSchema>>(HttpStatus.OK);
			}
			return new ResponseEntity<List<UserInformationSchema>>(userResults, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<UserInformationSchema>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@GetMapping("/home/{userId}")
	public ResponseEntity<List<UserPosts>> findPostsByFriendsOfUser(@PathVariable("userId") Long userId, @RequestHeader("Authorization") String authHeader) {
		try {

			List<UserPosts> userPosts = service.findAllFriendPostsByUserId(userId);
			
			if (userPosts == null) {
				return new ResponseEntity<List<UserPosts>>(HttpStatus.OK);
			}
			return new ResponseEntity<List<UserPosts>>(userPosts, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<UserPosts>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @GetMapping("/user/{userId}")
	// public ResponseEntity<List<UserPosts>> getAllPostsByUserId(@PathVariable("userId") Long userId, @RequestHeader("Authorization") String authHeader) {
	// 	try {
	// 		List<UserPosts> userPosts = service.findByUserId(userId);
		
	// 		if (userPosts == null) {
	// 			return new ResponseEntity<List<UserPosts>>(HttpStatus.OK);
	// 		}
	// 		return new ResponseEntity<List<UserPosts>>(userPosts, HttpStatus.OK);
	// 	} catch (NoSuchElementException e) {
	// 		return new ResponseEntity<List<UserPosts>>(HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }

	// @PostMapping("/create")
	// public ResponseEntity<Map<String, Object>> createPost (@RequestBody UserPosts request
	// ,@RequestHeader("Authorization") String authHeader
	// ){
	// 	try {
			
	// 		int requestResponse = service.createPost(request);
	// 		if (requestResponse == 200) {
	// 			Map<String, Object> response = new HashMap<>();
	// 			response.put("status", "success");
	// 			response.put("message", "Post successful");
				
	// 			return new ResponseEntity<>(response, HttpStatus.OK);
	// 		}
	// 		else {
	// 			Map<String, Object> response = new HashMap<>();
	// 			response.put("status", "error");
	// 			response.put("message", "Post failed");
	// 			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	// 		}
	// 	} catch (NoSuchElementException e) {
	// 		Map<String, Object> response = new HashMap<>();
	// 		response.put("status", "error");
	// 		response.put("message", "Internal server error");
	// 		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }
}








