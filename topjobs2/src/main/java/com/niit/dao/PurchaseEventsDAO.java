package com.niit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.niit.domain.Employer;
import com.niit.domain.Job;
import com.niit.domain.PurchaseEvents;
import com.niit.topjobs.PersistenceManager;

public class PurchaseEventsDAO {

	public void persist(PurchaseEvents entity)
	{
		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	

	
	public  List<PurchaseEvents> findAllPurchaseEvents() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PurchaseEvents> cq = cb.createQuery(PurchaseEvents.class);
		Root<PurchaseEvents> root = cq.from(PurchaseEvents.class);
		List<PurchaseEvents> ls = em.createQuery(cq).getResultList();
		em.getTransaction().commit();
		em.close();
		return ls;
	}
	
//	public PurchaseEvents findPurchaseEventById(PurchaseEvents entity)
//	{
//		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
//		em.getTransaction().begin();
//		em.find(PurchaseEvents.class,entity.getEventId());
//		em.getTransaction().commit();
//		em.close();
//		return entity;
//	}
	
	public PurchaseEvents findPurchaseEventById(PurchaseEvents entity)   //show jobs by employer
	{
		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<PurchaseEvents> cq = cb.createQuery(PurchaseEvents.class);
		Root<PurchaseEvents> root=cq.from(PurchaseEvents.class);
		cq.select(root);

		Metamodel m = em.getMetamodel();
		EntityType<PurchaseEvents> rEntity = m.entity(PurchaseEvents.class);
		Expression job_exp = root.get(rEntity.getSingularAttribute("eventId"));
		Predicate p1 = cb.equal(job_exp,entity.getEventId());
		cq.where(p1);

		PurchaseEvents dataObj= em.createQuery(cq).getSingleResult();
		em.getTransaction().commit();
		em.close();
		return dataObj;
	}
	
	
	public void deletePurchaseEventById(PurchaseEvents entity) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		entity=em.find(PurchaseEvents.class, entity.getEventId());
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}
	
}
