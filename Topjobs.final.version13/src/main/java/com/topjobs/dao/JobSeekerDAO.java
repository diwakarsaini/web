package com.topjobs.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.jupiter.api.Test;

import com.topjobs.domain.JobSeeker;
import com.topjobs.persistence.PersistenceManager;

public class JobSeekerDAO {

	
	public JobSeeker jobSeekerUsernameFind(JobSeeker js) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		js = em.find(JobSeeker.class, js.getUserName());
		em.getTransaction().commit();
		em.close();
		// PersistenceManager.INSTANCE.close();
		return js;
	}
																				// can use anyone of the given
	public  JobSeeker jobSeekerUsernameMeta(JobSeeker js) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobSeeker> cq = cb.createQuery(JobSeeker.class);
		Root<JobSeeker> root = cq.from(JobSeeker.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<JobSeeker> JsEntity = m.entity(JobSeeker.class);
		Expression username_exp = root.get(JsEntity.getSingularAttribute("userName"));			//field of domain class
		Predicate p1 = cb.equal(username_exp, js.getUserName());
		cq.where(p1);
		
		js = em.createQuery(cq).getSingleResult();
		em.getTransaction().commit();
		em.close();
		// PersistenceManager.INSTANCE.close();
		return js;
	}
	
	
}
