package com.qa.baetraining.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.baetraining.domain.UserInformationSchema;


@Repository
public interface UserRepo extends JpaRepository<UserInformationSchema, Long> {
	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE email = ?", nativeQuery = true)
	public UserInformationSchema getUserByEmail(String userEmail);

	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE user_name = ?", nativeQuery = true)
	public UserInformationSchema findUserByUsername(String userName);
	
	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE email = ?", nativeQuery = true)
	public UserInformationSchema findUserByEmail(String email);

	@Query(value = "SELECT id FROM UserLogin.user_information_schema WHERE email = ?", nativeQuery = true)
	public Long getIdByEmail(String userEmail);

	@Query(value = "SELECT * FROM UserLogin.user_information_schema", nativeQuery = true)
	public List<UserInformationSchema> allUsers();
	
	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE email = ? AND password = ?", nativeQuery = true)
	public UserInformationSchema signIn(String email, String password);


	//// SIGN UP

	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE email = ? OR user_name = ?", nativeQuery = true)
	public UserInformationSchema userExistsQuery(String email, String userName);

	@Modifying
	@Query(value  = "INSERT INTO UserLogin.user_information_schema (first_name, last_name, email, password, user_name, profile_pic,role) VALUES (:firstName, :lastName, :email, :password, :userName, :profilePic, :role)", nativeQuery = true)
	public void createUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("password") String password, @Param("userName") String userName, @Param("profilePic") String profilePic, @Param("role") String role);

	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE email = ?", nativeQuery = true)
	public UserInformationSchema emailExistsQuery(String email);

	@Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE user_name = ?", nativeQuery = true)
	public UserInformationSchema userNameExistsQuery(String userName);


}

