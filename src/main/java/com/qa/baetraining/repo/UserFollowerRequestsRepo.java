package com.qa.baetraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.baetraining.domain.UserFollowerRequests;
import com.qa.baetraining.domain.UserFriend;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;

@Repository
public interface UserFollowerRequestsRepo extends JpaRepository<UserFollowerRequests, UserFollowerRequests.UserRequestsId> {

    @Query("SELECT CASE WHEN (COUNT(uf) > 0) THEN true ELSE false END FROM UserFollowerRequests uf WHERE uf.user.id = :userId AND uf.requesterUser.id = :requesterUserId")
    boolean existRequestsByUseRId(@Param("userId") Long userId, @Param("requesterUserId") Long requesterUserId);

    @Query("SELECT uf.requesterUser FROM UserFollowerRequests uf WHERE uf.user.id = :userId")
    List<UserInformationSchema> findAllRequestsByUserId(@Param("userId") Long userId);

    @Modifying
	@Query(value  = "INSERT INTO UserLogin.user_follower_requests (user_id, requester_user_id) VALUES (:user_id, :requester_user_id)", nativeQuery = true)
	public void sendFriendRequestByUserId(@Param("user_id") Long userId, @Param("requester_user_id") Long requesterUserId);



    // @Query("SELECT uf.friend FROM UserFriend uf WHERE uf.user.id = :userId AND uf.friend.id = :friendId")
    // UserInformationSchema findAFriendByUserId(@Param("userId") Long userId, @Param("friendId") Long friendId);

    // @Query("SELECT CASE WHEN (COUNT(uf) > 0) THEN true ELSE false END FROM UserFriend uf WHERE uf.user.id = :userId AND uf.friend.id = :friendId")
    // boolean existsFriendByUserId(@Param("userId") Long userId, @Param("friendId") Long friendId);


    // @Query("SELECT p FROM UserFriend uf INNER JOIN UserPosts p ON uf.friend.id = p.user.id WHERE uf.user.id = :userId")
    // List<UserPosts> findAllFriendPostsByUserId(@Param("userId") Long userId);

    // @Query(value = "SELECT u FROM UserInformationSchema u WHERE u.firstName LIKE :firstName%")
    // List<UserInformationSchema> findUsersByName(@Param("firstName") String firstName);

    // @Query(value = "SELECT * FROM UserLogin.user_information_schema WHERE first_name = ?", nativeQuery = true)
    // List<UserInformationSchema> findUsersByName0(String firstName);
    
    // @Query(value = "SELECT u FROM UserInformationSchema u WHERE u.firstName = :firstName")
    // List<UserInformationSchema> findUsersByName1(@Param ("firstName") 
    // String firstName);

    // @Query(value = "SELECT u FROM UserInformationSchema u WHERE LOWER(u.firstName) LIKE LOWER(:firstName)%")
    // List<UserInformationSchema> findUsersByName2(@Param("firstName") String firstName);


    // @Query(value = "SELECT u FROM UserInformationSchema u WHERE u.firstName = :id")
    // List<UserInformationSchema> findUserProfileById(@Param ("id") String id);


    // Add friend

    // Delete friend

    //view friend profile

    //send friend request

    //accept friend request

    //cancel friend request
}
