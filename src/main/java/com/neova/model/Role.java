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

@Entity
@Table(name = "neovarole", catalog = "neova")
public class Role implements Serializable {

	private static final long serialVersionUID = -4238733882336114492L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupRoleID.role", cascade = CascadeType.ALL)
	private Set<GroupRole> groupRoles = new HashSet<GroupRole>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;

	private String roleName;

	public Role() {
		// Default Constructor
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Set<GroupRole> getGroupRoles() {
		return groupRoles;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setGroupRoles(Set<GroupRole> groupRoles) {
		this.groupRoles = groupRoles;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String toString() {
		return "_________________________________________________"
				+ "\n This is Role Data of Role" + this.getRoleId()
				+ "\n Role Name : " + this.getRoleName();
	}
}
