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

import com.neova.model.jointable.GroupRole;
import com.neova.model.jointable.UserGroup;

@Entity
@Table(name = "neovagroup", catalog = "neova")
public class Group implements Serializable {

	private static final long serialVersionUID = -7336474250618387810L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groupId;

	private String groupName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupRoleID.group", cascade = CascadeType.ALL)
	private Set<GroupRole> groupRoles = new HashSet<GroupRole>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userGroupID.group", cascade = CascadeType.ALL)
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);

	public Group() {
	}

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public Set<GroupRole> getGroupRoles() {
		return groupRoles;
	}

	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setGroupRoles(Set<GroupRole> groupRoles) {
		this.groupRoles = groupRoles;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public String toString() {
		return "_________________________________________________"
				+ "\n This is Group Data of Group" + this.getGroupId()
				+ "\n Group Name : " + this.getGroupName();
	}

}
