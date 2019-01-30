package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.niit.dao.EmployerDAO;
import com.niit.dao.PurchaseEventsDAO;
import com.niit.domain.Employer;
import com.niit.domain.Job;
import com.niit.domain.PurchaseEvents;
import com.niit.topjobs.PersistenceManager;

class purchaseTest {

	@Test
	void test() {
		PurchaseEvents purchaseEvent = new PurchaseEvents();
		purchaseEvent.setEventId(52L);
		PurchaseEventsDAO pDAO = new PurchaseEventsDAO();
		purchaseEvent = pDAO.findPurchaseEventById(purchaseEvent);
		
		System.out.println(purchaseEvent);
		Employer emp = new Employer();
		emp.setUser_name(purchaseEvent.getEmployer().getUser_name());
		System.out.println(emp);
	}
	
	
	@Test
	public void viewJobByEmployer()   //show jobs by employer
	{
		Employer emp = new Employer();
		emp.setUser_name("d13");
		EntityManager em=PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<PurchaseEvents> cq = cb.createQuery(PurchaseEvents.class);
		Root<PurchaseEvents> root=cq.from(PurchaseEvents.class);
		cq.select(root);

		Metamodel m = em.getMetamodel();
		EntityType<PurchaseEvents> rEntity = m.entity(PurchaseEvents.class);
		Expression job_exp = root.get(rEntity.getSingularAttribute("eventId"));
		Predicate p1 = cb.equal(job_exp,52L);
		cq.where(p1);

		PurchaseEvents dataObj= em.createQuery(cq).getSingleResult();
		em.getTransaction().commit();
		em.close();
		System.out.println(dataObj);
	}

}
