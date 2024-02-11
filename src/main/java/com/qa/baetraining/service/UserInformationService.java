package com.qa.baetraining.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserSignUp;
// import com.qa.baetraining.exceptions.UserNotFound;
import com.qa.baetraining.repo.UserRepo;

@Service
public class UserInformationService {
	private UserRepo repo;

	public UserInformationService(UserRepo repo) {
		this.repo = repo;
	}
	
	public UserInformationSchema findUserByUsername(String userName) {
		return repo.findUserByUsername(userName);
	}

	public UserInformationSchema findUserByEmail(String email) {
		return repo.getUserByEmail(email);
	}

	public Long getIdByEmail(String userEmail) {
		try{
			Long result = repo.getIdByEmail(userEmail);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<UserInformationSchema> allUsers() {
		return this.repo.allUsers();	
	}

    public int signIn(String email, String password) {
        UserInformationSchema user = this.repo.signIn(email, password);
        if (user != null) {
            return 200;
        } else {
            return 500;
        }
    }

	@Transactional
	public int signUp(UserSignUp userSignUp) {
		String role = "USER";
		try {
			System.out.println(userSignUp.getEmail());
			UserInformationSchema userExists = this.repo.userExistsQuery(userSignUp.getEmail(), userSignUp.getUserName());

			if (userExists == null) {
				this.repo.createUser(userSignUp.getFirstName(), userSignUp.getLastName(), userSignUp
				.getEmail(), userSignUp.getPassword(), userSignUp.getUserName(), userSignUp.getProfilePic(), role);
				return 200;
			} else {
				return 409;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
	}
}

