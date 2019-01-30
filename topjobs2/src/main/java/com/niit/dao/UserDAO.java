package com.niit.dao;

import javax.persistence.EntityManager;

import com.niit.domain.User;
import com.niit.topjobs.PersistenceManager;

public class UserDAO {

	public  User findUserByUsername(User user) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		user=em.find(User.class, user.getUser_name());
		em.getTransaction().commit();
		em.close();
		return user;
	}

	public  User findUserByUsername(String username) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		User user = new User();
		user=em.find(User.class, username);
		em.getTransaction().commit();
		em.close();
		return user;
	}

}
