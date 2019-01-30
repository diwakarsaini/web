package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.niit.domain.JobSeeker;
import com.niit.domain.User;
import com.niit.domain.UserRole;
import com.niit.topjobs.PersistenceManager;

class AdminTest {

	@Test
	void test() {

		User user = new User();
		user.setFname("Gyanendra");
		user.setLname("Sir");
		user.setUser_name("admin");
		user.setUser_pass("admin");
		
		UserRole ur = new UserRole();
		ur.setRole_name("Admin");
		ur.setUser_name("admin");
		
		user.setUserRole(ur);
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	    em.getTransaction().begin();
	    em.persist(user);
	    em.getTransaction().commit();
	    em.close();

	}

}
