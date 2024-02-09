// package com.qa.baetraining.domain;

// import java.time.LocalDateTime;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// @Entity
// @Table(name = "reactions")
// public class PostReactions {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private UserInformationSchema user;

//     @ManyToOne
//     @JoinColumn(name = "post_id", nullable = false)
//     private UserPosts post;

//     @Column(name = "reaction_type")
//     private String reactionType; // This could be an enum in a real application

//     @Column(name = "timestamp")
//     private LocalDateTime timestamp;



//     public long getId() {
//         return id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public UserInformationSchema getUser() {
//         return user;
//     }

//     public void setUser(UserInformationSchema user) {
//         this.user = user;
//     }

//     public UserPosts getPost() {
//         return post;
//     }

//     public void setPost(UserPosts post) {
//         this.post = post;
//     }

//     public String getReactionType() {
//         return reactionType;
//     }

//     public void setReactionType(String reactionType) {
//         this.reactionType = reactionType;
//     }

//     public LocalDateTime getTimestamp() {
//         return timestamp;
//     }

//     public void setTimestamp(LocalDateTime timestamp) {
//         this.timestamp = timestamp;
//     }

    
// }
