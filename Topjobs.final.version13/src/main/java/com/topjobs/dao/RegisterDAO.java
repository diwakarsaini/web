package com.topjobs.dao;

import javax.persistence.EntityManager;

import com.topjobs.domain.User;
import com.topjobs.persistence.PersistenceManager;

public class RegisterDAO {

	public void persist(User entity) {
		// TODO Auto-generated method stub
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();

		//	PersistenceManager.INSTANCE.close();

	}
}
