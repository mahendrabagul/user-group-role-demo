package com.neova.model.jointable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.neova.model.Group;
import com.neova.model.Role;
import com.neova.model.embedded.id.GroupRoleID;

@Entity
@Table(name = "group_role", catalog = "neova")
@AssociationOverrides({
		@AssociationOverride(name = "groupRoleID.group", joinColumns = @JoinColumn(name = "GROUP_ID")),
		@AssociationOverride(name = "groupRoleID.role", joinColumns = @JoinColumn(name = "ROLE_ID")) })
public class GroupRole implements Serializable {

	private static final long serialVersionUID = 7547671742834389644L;
	@EmbeddedId
	GroupRoleID groupRoleID = new GroupRoleID();
	private Date registered;

	public GroupRole() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroupRole))
			return false;
		GroupRole other = (GroupRole) obj;
		if (groupRoleID == null) {
			if (other.groupRoleID != null)
				return false;
		} else if (!groupRoleID.equals(other.groupRoleID))
			return false;
		if (registered == null) {
			if (other.registered != null)
				return false;
		} else if (!registered.equals(other.registered))
			return false;
		return true;
	}

	@Transient
	public Group getGroup() {
		return getGroupRoleID().getGroup();
	}

	public GroupRoleID getGroupRoleID() {
		return groupRoleID;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTERED", nullable = false, length = 10)
	public Date getRegistered() {
		return registered;
	}

	@Transient
	public Role getRole() {
		return getGroupRoleID().getRole();
	}

	@Override
	public int hashCode() {
		return (getGroupRoleID() != null ? getGroupRoleID().hashCode() : 0);
	}

	public void setGroup(Group group) {
		getGroupRoleID().setGroup(group);
	}

	public void setGroupRoleID(GroupRoleID groupRoleID) {
		this.groupRoleID = groupRoleID;
	}

	public void setRole(Role role) {
		getGroupRoleID().setRole(role);
	}
}
