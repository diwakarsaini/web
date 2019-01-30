package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.jupiter.api.Test;

import com.niit.domain.Job;
import com.niit.domain.JobSeeker;
import com.niit.domain.JobSeekerEvents;
import com.niit.topjobs.PersistenceManager;

class JobSeekerEventTest {

	
	
	@Test
	public void findJobEventsByUsername() {
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setUser_name("d1");
		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<JobSeekerEvents> cq = cb.createQuery(JobSeekerEvents.class);
		Root<JobSeekerEvents> root=cq.from(JobSeekerEvents.class);
		cq.select(root);

		Metamodel m = em.getMetamodel();
		EntityType<JobSeekerEvents> rEntity = m.entity(JobSeekerEvents.class);
		Expression job_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
		Predicate p1 = cb.equal(job_exp,jobSeeker);
		cq.where(p1);

		List<JobSeekerEvents> dataObj= em.createQuery(cq).getResultList();
		em.getTransaction().commit();
		em.close();
		for(JobSeekerEvents obj:dataObj) {
			System.out.println(obj);
		}
	}
}
