package com.niit.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.niit.domain.Job;
import com.niit.domain.Resume;
import com.niit.ro.ResumeRequest;
import com.niit.topjobs.PersistenceManager;
import com.niit.domain.JobSeeker;

public class ResumeDAO {

	public void merge(Resume entity) {
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public Resume viewResumeEmployer(ResumeRequest obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Resume> cq = cb.createQuery(Resume.class);
		Root<Resume> root = cq.from(Resume.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<Resume> rEntity = m.entity(Resume.class);
		Expression resume_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
		Predicate p1 = cb.equal(resume_exp,obj.getJobSeeker());
		cq.where(p1);
		Resume dataObj = em.createQuery(cq).getSingleResult();

		dataObj.setTimesViewed(dataObj.getTimesViewed()+1);
		
		em.merge(dataObj);
		em.getTransaction().commit();
		em.close();
		
		return dataObj;

	}
	
	public Resume viewResumeEmployer(JobSeeker obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Resume> cq = cb.createQuery(Resume.class);
		Root<Resume> root = cq.from(Resume.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<Resume> rEntity = m.entity(Resume.class);
		Expression resume_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
		Predicate p1 = cb.equal(resume_exp,obj);
		cq.where(p1);
		Resume dataObj = em.createQuery(cq).getSingleResult();

		dataObj.setTimesViewed(dataObj.getTimesViewed()+1);
		
		em.merge(dataObj);
		em.getTransaction().commit();
		em.close();
		
		return dataObj;

	}
	
	public Resume viewResumeJobSeeker(ResumeRequest obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Resume> cq = cb.createQuery(Resume.class);
		Root<Resume> root = cq.from(Resume.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<Resume> rEntity = m.entity(Resume.class);
		Expression resume_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
		Predicate p1 = cb.equal(resume_exp,obj.getJobSeeker());
		cq.where(p1);
		Resume dataObj = em.createQuery(cq).getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return dataObj;

	}
	
	public Resume viewResumeJobSeekerCreate(JobSeeker obj) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Resume> cq = cb.createQuery(Resume.class);
		Root<Resume> root = cq.from(Resume.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<Resume> rEntity = m.entity(Resume.class);
		Expression resume_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
		Predicate p1 = cb.equal(resume_exp,obj);
		cq.where(p1);
		Resume dataObj = em.createQuery(cq).getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return dataObj;
	}
}
