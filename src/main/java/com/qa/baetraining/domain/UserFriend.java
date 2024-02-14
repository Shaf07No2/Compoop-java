package com.qa.baetraining.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_friend")
public class UserFriend {

    @Embeddable
    public static class UserFriendsId implements Serializable {

        @Column(name = "user_id")
        private long userId;

        @Column(name = "friend_id")
        private long friendId;

        // getters and setters 

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getFriendId() {
            return friendId;
        }

        public void setFriendId(long friendId) {
            this.friendId = friendId;
        }

        // toString 
        
        @Override
        public String toString() {
            return "UserFriendsId [userId=" + userId + ", friendId=" + friendId + "]";
        }
    }

    @EmbeddedId
    private UserFriendsId id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @MapsId("userId")
    private UserInformationSchema user;

    @ManyToOne
    @JoinColumn(name = "friend_id", insertable = false, updatable = false)
    @MapsId("friendId")
    private UserInformationSchema friend;


    // getters setters

    public UserFriendsId getId() {
        return id;
    }

    public void setId(UserFriendsId id) {
        this.id = id;
    }

    public UserInformationSchema getUser() {
        return user;
    }

    public void setUser(UserInformationSchema user) {
        this.user = user;
    }

    public UserInformationSchema getFriend() {
        return friend;
    }

    public void setFriend(UserInformationSchema friend) {
        this.friend = friend;
    }



    //toString

    @Override
    public String toString() {
        return "UserFriends [id=" + id + ", user=" + user + ", friend=" + friend + "]";
    }
}
