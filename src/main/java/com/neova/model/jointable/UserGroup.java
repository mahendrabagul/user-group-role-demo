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
import com.neova.model.User;
import com.neova.model.embedded.id.UserGroupID;

@Entity
@Table(name = "user_group", catalog = "neova")
@AssociationOverrides({
		@AssociationOverride(name = "userGroupID.user", joinColumns = @JoinColumn(name = "USER_ID")),
		@AssociationOverride(name = "userGroupID.group", joinColumns = @JoinColumn(name = "GROUP_ID")) })
public class UserGroup implements Serializable {
	private static final long serialVersionUID = -9210264937753443719L;
	private Date registered;

	@EmbeddedId
	private UserGroupID userGroupID = new UserGroupID();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserGroup))
			return false;
		UserGroup other = (UserGroup) obj;
		if (userGroupID == null) {
			if (other.userGroupID != null)
				return false;
		} else if (!userGroupID.equals(other.userGroupID))
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
		return getUserGroupID().getGroup();
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTERED", nullable = false, length = 10)
	public Date getRegistered() {
		return registered;
	}

	@Transient
	public User getUser() {
		return getUserGroupID().getUser();
	}

	public UserGroupID getUserGroupID() {
		return userGroupID;
	}

	public UserGroup() {
	}

	@Override
	public int hashCode() {
		return (getUserGroupID() != null ? getUserGroupID().hashCode() : 0);
	}

	public void setGroup(Group group) {
		getUserGroupID().setGroup(group);
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public void setUser(User user) {
		getUserGroupID().setUser(user);
	}

	public void setUserGroupID(UserGroupID userGroupID) {
		this.userGroupID = userGroupID;
	}

}
