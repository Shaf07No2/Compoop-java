package com.qa.baetraining.domain;

public class UserSignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private String userName;

    // Getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getProfilePic() {
        return this.profilePic;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    @Override
    public String toString() {
        return "UserSignUp [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", profilePic=" + profilePic + ", userName=" + userName + "]";
    }
}

