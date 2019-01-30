package com.niit.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import com.niit.domain.Employer;
import com.niit.domain.Job;
import com.niit.topjobs.PersistenceManager;

public class EmployerDao {

	
	public void merge(Employer entity) {
		// TODO Auto-generated method stub
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
		
//	PersistenceManager.INSTANCE.close();
	
	}
	
	
	public void PurchaseLogin(Employer emp)
	{
		
		Date date=new Date();
		emp.setPurchaseDate(date);
		emp.setActive(true);
		
		
		merge(emp);
	
	}
	}


