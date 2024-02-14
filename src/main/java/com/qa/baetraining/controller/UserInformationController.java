package com.qa.baetraining.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.crypto.spec.SecretKeySpec;

import io.github.cdimascio.dotenv.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
// import java.security.Key;
import java.util.Date;


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

import com.qa.baetraining.domain.UserFriend;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserSignUp;
import com.qa.baetraining.security.JwtRequestFilter;
import com.qa.baetraining.security.JwtTokenUtil;
import com.qa.baetraining.service.UserFriendService;
import com.qa.baetraining.service.UserInformationService;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
@RestController
public class UserInformationController {

	public UserInformationService service;

	public UserFriendService friendService;
	
	public UserInformationController(UserInformationService service, UserFriendService friendService) {
		this.service = service;
		this.friendService = friendService;
	}

	Dotenv dotenv = Dotenv.load();

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/profile/{userId}")
	public ResponseEntity<UserInformationSchema> findById(@PathVariable("userId") String friendId, @RequestHeader("Authorization") String authHeader) {
		try {
			//this is the id of the random profile youre trying to view converted to long type
			long formattedFriendId = Long.parseLong(friendId);

			//extracting the requesters id from the token to check if the requester is friends with the profile they are trying to view
			String token = authHeader.substring(7).trim();
			long requesterId = jwtTokenUtil.getUserIdString(token);
			

			//searching to see if the profile belongs to anyone
			UserInformationSchema friendUser = service.findById(formattedFriendId);

			//if no user exist then return not found
			if (friendUser == null) {
				return new ResponseEntity<UserInformationSchema>(HttpStatus.NOT_FOUND);
			} else if (formattedFriendId == requesterId) {
				return new ResponseEntity<UserInformationSchema>(friendUser, HttpStatus.OK);
			} else {
				//here we check the user (friendID) to see if it exists against the requesterId (userId) in the UserFriend table.
				Boolean areUsersFriends = friendService.existsFriendByUserId(requesterId, formattedFriendId);
				if (areUsersFriends) {
					return new ResponseEntity<UserInformationSchema>(friendUser, HttpStatus.OK);
				} else {
					return new ResponseEntity<UserInformationSchema>(HttpStatus.UNAUTHORIZED);
				}
			}
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserInformationSchema>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> signIn(@RequestBody Map<String, String> request) {
		String email = request.get("email");
		String password = request.get("password");
		try {

		
			int requestResponse = service.signIn(email, password);

			
			if (requestResponse == 200) {
				// System.out.println(email);
				Long userId = service.getIdByEmail(email);
				System.out.println(userId);
				Map<String, Object> response = new HashMap<>();
				String token = Jwts.builder().setClaims(response)
                    .claim("sub", email)
					.claim("userId", userId)
                    .claim("iat", new Date())
                    .claim("exp", new Date(System.currentTimeMillis() + 86400000))
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(dotenv.get("ACCESS_TOKEN_SECRET"))))
                    .compact();
				response.put("status", "success");
				response.put("message", "Login successful");
				// response.put()
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.SET_COOKIE, "session_id=1234567890; Path=/; HttpOnly");
				headers.set("Authorization", "Bearer " + token);
				headers.add("Access-Control-Expose-Headers", "Authorization");
			

				return new ResponseEntity<>(response, headers, HttpStatus.OK);
			}
			else {
				Map<String, Object> response = new HashMap<>();
				response.put("status", "error");
				response.put("message", "Invalid credentials");
				return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
			}
		} catch (NoSuchElementException e) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "User not found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> signUp(@RequestBody UserSignUp request){
		try {
			int requestResponse = service.signUp(request);

			
			if (requestResponse == 200) {
				Long userId = service.getIdByEmail(request.getEmail());
				Map<String, Object> response = new HashMap<>();
				String token = Jwts.builder().setClaims(response)
                    .claim("sub", request.getEmail())
					.claim("userId", userId)
                    .claim("iat", new Date())
                    .claim("exp", new Date(System.currentTimeMillis() + 86400000))
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(dotenv.get("ACCESS_TOKEN_SECRET"))))
                    .compact();
				response.put("status", "success");
				response.put("message", "Sign up successful");
				
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.SET_COOKIE, "session_id=1234567890; Path=/; HttpOnly");
				headers.set("Authorization", "Bearer " + token);
				headers.add("Access-Control-Expose-Headers", "Authorization");
				

				return new ResponseEntity<>(response, headers, HttpStatus.OK);
			}
			else {
				Map<String, Object> response = new HashMap<>();
				response.put("status", "error");
				response.put("message", "User already exists");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);
			}
		} catch (NoSuchElementException e) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Internal server error");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// @PostMapping("/profile")
	// public ResponseEntity<UserInformationSchema> findUserByUsername(@RequestHeader("Authorization") String authHeader) {
	// 	String token = authHeader.substring(7).trim();

	// 	String email = jwtTokenUtil.getUsernameFromToken(token);


	// 	try {
	// 		UserInformationSchema user = service.findUserByEmail(email);
		
	// 		if (user == null) {
	// 			return new ResponseEntity<UserInformationSchema>(HttpStatus.NOT_FOUND);
	// 		}
	// 		System.out.println(user);
	// 		return new ResponseEntity<UserInformationSchema>(user, HttpStatus.OK);
	// 	} catch (NoSuchElementException e) {
	// 		return new ResponseEntity<UserInformationSchema>(HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }
}










