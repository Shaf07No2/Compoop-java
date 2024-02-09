package com.qa.baetraining.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="user_posts")
public class UserPosts {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "picture", length = 500)
    private String picture;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserInformationSchema user;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;


public UserPosts(){
};

public UserPosts(long id, String title, String description, String picture, UserInformationSchema user) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.user = user;
}

public UserPosts(String title, String description, String picture, UserInformationSchema user, LocalDateTime date) {
        super();
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.user = user;
        this.date = date;
}


public UserInformationSchema getUser() {
        return user;
}

public void setUser(UserInformationSchema user) {
        this.user = user;
}

public long getId() {
        return id;
}

public void setId(long id) {
        this.id = id;
}

public String getTitle() {
        return title;
}

public void setTitle(String title) {
        this.title = title;
}

public String getDescription() {
        return description;
}

public void setDescription(String description) {
        this.description = description;
}

public LocalDateTime getDate() {
        return date;
}

public void setDate(LocalDateTime date) {
        this.date = date;
}

public String getPicture() {
        return picture;
}

public void setPicture(String picture) {
        this.picture = picture;
}

@Override
public String toString() {
        return "UserPosts [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
                        + ", picture=" + picture + ", user=" + user + "]";
}

   
}
