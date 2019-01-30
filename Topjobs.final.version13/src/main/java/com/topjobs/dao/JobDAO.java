package com.topjobs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.topjobs.domain.Job;
import com.topjobs.persistence.PersistenceManager;



public class JobDAO {

	public void persist(Job entity) {
		// TODO Auto-generated method stub
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();

		//	PersistenceManager.INSTANCE.close();

	}
	public  List<Job> findAllJobs() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Job> cq = cb.createQuery(Job.class);
		Root<Job> root = cq.from(Job.class);
		List<Job> ls = em.createQuery(cq).getResultList();
		em.getTransaction().commit();
		em.close();
		// PersistenceManager.INSTANCE.close();
		return ls;
	}
	
	
	public List<Job> findJobByUsername(Job obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Job> cq = cb.createQuery(Job.class);
		Root<Job> root = cq.from(Job.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<Job> Job_ = m.entity(Job.class);
		Expression username_exp = root.get(Job_.getSingularAttribute("user_name"));
		
		Predicate p1 = cb.equal(username_exp, obj.getEmployer().getUserName());

		
		em.getTransaction().commit();
		em.close();
		// PersistenceManager.INSTANCE.close();
		return null;
	}
	
	public Job findJobByID(Job obj) {
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		obj = em.find(Job.class, obj.getJobId());
		em.getTransaction().commit();
		em.close();
		return obj;
	}

}
