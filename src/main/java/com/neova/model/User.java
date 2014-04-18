package com.neova.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.neova.model.jointable.UserGroup;

@Entity
@Table(name = "neovauser", catalog = "neova")
public class User implements Serializable {

	private static final long serialVersionUID = 4007596176781681354L;

	private String firstName;

	private boolean isEnabled;

	private String lastName;

	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userGroupID.user", cascade = CascadeType.ALL)
	private Set<UserGroup> userGroup = new HashSet<UserGroup>(0);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String userName;

	public User() {
		// Default Constructor
	}

	public User(String firstName, String lastName, String userName,
			String password, boolean isEnabled) {
		super();
		this.firstName = firstName;
		this.isEnabled = isEnabled;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public Set<UserGroup> getUserGroup() {
		return userGroup;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserGroup(Set<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		return "_________________________________________________"
				+ "\n This is User Data of User" + this.getUserId()
				+ "\n First Name : " + this.getFirstName() + "\n Last Name : "
				+ this.getLastName() + "\n User Name : " + this.getUserName()
				+ "\n Password : " + this.getPassword();

	}

}
