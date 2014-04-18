package com.neova.main;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.neova.model.Group;
import com.neova.model.Role;
import com.neova.model.User;
import com.neova.model.jointable.GroupRole;
import com.neova.model.jointable.UserGroup;
import com.neova.util.HibernateUtil;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		if (logger.isDebugEnabled()) {
			logger.debug(session);
		}
		session.beginTransaction();
		User user1 = new User("Mahendra", "Bagul", "mahi", "mahi", true);
		session.save(user1);

		User user2 = new User("Aryan", "Bagul", "aryan", "aryan", true);
		session.save(user2);

		Role role1 = new Role("ROLE_ADMIN");
		session.save(role1);

		Role role2 = new Role("ROLE_MODERATOR");
		session.save(role2);

		Group group1 = new Group("ADMIN");
		session.save(group1);

		Group group2 = new Group("USER");
		session.save(group2);

		GroupRole groupRole1 = new GroupRole();
		groupRole1.setGroup(group1);
		groupRole1.setRole(role2);
		groupRole1.setRegistered(new Date());
		role1.getGroupRoles().add(groupRole1);

		GroupRole groupRole2 = new GroupRole();
		groupRole2.setGroup(group2);
		groupRole2.setRole(role2);
		groupRole2.setRegistered(new Date());
		role2.getGroupRoles().add(groupRole2);

		UserGroup userGroup1 = new UserGroup();
		userGroup1.setGroup(group1);
		userGroup1.setUser(user1);
		userGroup1.setRegistered(new Date());
		user1.getUserGroup().add(userGroup1);
		session.save(user1);

		UserGroup userGroup2 = new UserGroup();
		userGroup2.setGroup(group2);
		userGroup2.setUser(user2);
		userGroup2.setRegistered(new Date());
		user2.getUserGroup().add(userGroup2);
		session.save(user2);
		session.getTransaction().commit();
		System.out.println("Changes Committed");

	}
}