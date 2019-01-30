package com.topjobs.dao;

import javax.persistence.EntityManager;

import com.topjobs.domain.JobSeekerEvents;
import com.topjobs.persistence.PersistenceManager;


public class JobSeekerEventsDao {

	public void persist(JobSeekerEvents entity)
	{
		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
}
