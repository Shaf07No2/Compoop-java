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
@Table(name = "user_follower_requests")
public class UserFollowerRequests {

    @Embeddable
    public static class UserRequestsId implements Serializable {

        @Column(name = "user_id")
        private long userId;

        @Column(name = "requester__user_id")
        private long requesterUserId;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getRequesterUserId() {
            return requesterUserId;
        }

        public void setRequesterUserId(long requesterUserId) {
            this.requesterUserId = requesterUserId;
        }

        @Override
        public String toString() {
            return "UserRequestsId [userId=" + userId + ", requesterUserId=" + requesterUserId + "]";
        }

        // getters and setters 

        // toString 
        
    }

    @EmbeddedId
    private UserRequestsId id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @MapsId("userId")
    private UserInformationSchema user;

    @ManyToOne
    @JoinColumn(name = "requester_user_id", insertable = false, updatable = false)
    @MapsId("requesterUserId")
    private UserInformationSchema requesterUser;

    public UserRequestsId getId() {
        return id;
    }

    public void setId(UserRequestsId id) {
        this.id = id;
    }

    public UserInformationSchema getUser() {
        return user;
    }

    public void setUser(UserInformationSchema user) {
        this.user = user;
    }

    public UserInformationSchema getRequestUser() {
        return requesterUser;
    }

    public void setRequestUser(UserInformationSchema requestUser) {
        this.requesterUser = requestUser;
    }

    @Override
    public String toString() {
        return "UserFollowers [id=" + id + ", user=" + user + ", requesterUser=" + requesterUser + "]";
    }


    // getters setters

    



    //toString

   
}
