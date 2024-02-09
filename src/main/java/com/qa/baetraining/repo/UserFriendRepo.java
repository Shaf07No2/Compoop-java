package com.qa.baetraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.baetraining.domain.UserFriend;
import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.domain.UserPosts;

@Repository
public interface UserFriendRepo extends JpaRepository<UserFriend, UserFriend.UserFriendsId> {


    @Query("SELECT uf.friend FROM UserFriend uf WHERE uf.user.id = :userId")
    List<UserInformationSchema> findAllFriendsByUserId(@Param("userId") Long userId);


    @Query("SELECT p FROM UserFriend uf INNER JOIN UserPosts p ON uf.friend.id = p.user.id WHERE uf.user.id = :userId")
    List<UserPosts> findAllFriendPostsByUserId(@Param("userId") Long userId);

    // Add friend

    // Delete friend

    //view friend profile

    //send friend request

    //accept friend request

    //cancel friend request
}
