package com.qa.baetraining.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInformationSchema {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstName", length = 50, nullable = false) 
	private String firstName;

	@Column(name = "lastName", length = 50, nullable = false) 
	private String lastName;

	@Column(name = "email", length = 50, nullable = false) 
	private String email;
	
	@Column(name = "password", length = 50, nullable = false) 
	private String password;

	@Column(name = "userName", length = 50, nullable = false) 
	private String userName;
	
    @Column(name = "profilePic", length = 500, nullable = true) 
	private String profilePic;

	@Column(name = "role", length = 50, nullable = false) 
	private String role;
	
public UserInformationSchema() {
}

public UserInformationSchema(String firstName, String lastName, String email, String password, String userName, String profilePic, String role) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = userName;
    this.profilePic = profilePic;
    this.role = role;
}

public UserInformationSchema(long id, String firstName, String lastName, String email, String password, String userName, String profilePic, String role) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userName = userName;
    this.profilePic = profilePic;
    this.role = role;
}



public String getProfilePic() {
    return profilePic;
}

public void setProfilePic(String profilePic) {
    this.profilePic = profilePic;
}

public long getId() {
    return id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getRole(){
    return role;
}

public void setRole(String role){
    this.role = role;
}
	
//------

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((profilePic == null) ? 0 : profilePic.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserInformationSchema other = (UserInformationSchema) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (profilePic == null) {
            if (other.profilePic != null)
                return false;
        } else if (!profilePic.equals(other.profilePic))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserInformationSchema [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", password=" + password + ", userName=" + userName + ", profilePic=" + profilePic + ", role="
                + role + "]";
    }
    
}
