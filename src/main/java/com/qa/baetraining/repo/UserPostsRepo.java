package com.qa.baetraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.baetraining.domain.UserPosts;
import com.qa.baetraining.domain.UserInformationSchema;


@Repository
public interface UserPostsRepo extends JpaRepository<UserPosts, Long> {

    // GET REQUESTS

	// Get all of user's posts
	// @Query(value = "SELECT p FROM UserPosts WHERE p.user.id = :userId")
	// public List<UserPosts> findByUser_Id(@Param("userId") Long userId);

	@Query("SELECT u FROM UserPosts u WHERE u.user.id = :userId")
    List<UserPosts> findByUser_Id(@Param("userId") Long userId);

	// @Query("SELECT u FROM UserPosts u WHERE u.user.id = :userId")
    // List<UserPosts> findByUser_Id(@Param("userId") Long userId);

    // POST REQUESTS
	@Modifying
	@Query(value  = "INSERT INTO UserLogin.user_posts (title, description, picture, user_id) VALUES (:title, :description, :picture, :user_id)", nativeQuery = true)
	public void createPost(@Param("title") String title, @Param("description") String description, @Param("picture") String picture, @Param("user_id") Long userId);
}


// @Repository
// public interface UserPostsRepository extends JpaRepository<UserPosts, Long> {

//     @Query("SELECT p FROM UserPosts p WHERE p.user.id = :userId")
//     List<UserPosts> findByUserId(@Param("userId") Long userId);
// }

