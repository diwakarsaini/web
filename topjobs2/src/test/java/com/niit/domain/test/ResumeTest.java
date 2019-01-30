package com.niit.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.domain.Address;
import com.niit.domain.JSMarks;
import com.niit.domain.JobSeeker;
import com.niit.domain.Resume;
import com.niit.domain.User;
import com.niit.topjobs.PersistenceManager;
import com.niit.dao.JobSeekerDAO;
import com.niit.dao.ResumeDAO;

class ResumeTest {

	@Test
	void testToJSON() throws IOException {
		Resume rs=new Resume();
		JobSeeker user=new JobSeeker();
		user.setUser_name("diwakar10");
		rs.setJobSeeker(user);
		rs.setEmail("mathur@gmail.com");
		rs.setContactNum("9818282189");
		Address addr=new Address();
		addr.setAddLine("68, Anekant Appt");
		addr.setCity("delhi");
		addr.setState("Delhi");
		addr.setPin("110096");
		rs.setAddress(addr);
		JSMarks jsm=new JSMarks();
		jsm.setMarks10(80.00);
		jsm.setMarks12(88.00);
		jsm.setGradMarks(86.00);
		rs.setJsMarks(jsm);
		ArrayList<String> al=new ArrayList<String>();
		al.add("Java");
		al.add("C++");
		al.add("HTML");
		rs.setSkills(al);
		//Making JSON and adding ResumeText along with other parameters into single parameter
		ObjectMapper objectMapper = new ObjectMapper();
		String resumeString = objectMapper.writeValueAsString(rs);
		rs.setResumeText(resumeString);
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(rs);
		em.getTransaction()
		.commit();
		em.getTransaction().begin();
		Resume s=em.find(Resume.class, 1002);
		em.getTransaction()
		.commit();
		em.close();
		ObjectMapper obj=new ObjectMapper();
		Resume s2=obj.readValue(s.getResumeText(), Resume.class);
	}

	
	@Test
	void resumeInsert() throws JsonProcessingException {
			Resume rs = new Resume();
			JobSeeker js =jobSeekerUsername("d1");

			rs.setResumeId(252L);
			rs.setJobSeeker(js);;
			rs.setName("Abhayy");
			rs.setEmail("diwakar@gmail.com");
			rs.setContactNum("8447849901");
			
			Address addr = new Address();
			addr.setAddLine("3951. Ahiran Street");
			addr.setCity("Delhi");
			addr.setState("Delhi");
			addr.setPin("110006");
			rs.setAddress(addr);
			
			List<String> ls = new ArrayList<>();
			ls.add("java");
			ls.add("c++");
			ls.add("html");
			ls.add("hiberate");
			rs.setSkills(ls);
			
			JSMarks jsmarks = new JSMarks();
			jsmarks.setMarks10(98.7);
			jsmarks.setMarks12(99.5);
			jsmarks.setGradMarks(99.99);
			rs.setJsMarks(jsmarks);
			System.out.println(rs);
			
			ObjectMapper om = new ObjectMapper();
			String rStr = om.writeValueAsString(rs);
			System.out.println(rStr);
			rs.setResumeText(rStr);
			js.setResume(rs);

			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			em.merge(rs);
			em.getTransaction().commit();
			em.close();
			
		}
		
		
		@Test
		void viewResume() throws JsonParseException, JsonMappingException, IOException {
			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Resume> cq = cb.createQuery(Resume.class);
			Root<Resume> root = cq.from(Resume.class);
			cq.select(root);
			
			Metamodel m = em.getMetamodel();
			EntityType<Resume> rEntity = m.entity(Resume.class);
			Expression resume_exp = root.get(rEntity.getSingularAttribute("jobSeeker"));
			
			JobSeeker user = new JobSeeker();
			user.setUser_name("d9");
			
			Predicate p1 = cb.equal(resume_exp,user);
			
			cq.where(p1);
			
			Resume dataObj = em.createQuery(cq).getSingleResult();
			
			System.out.println(dataObj);
			System.out.println("=============================");
			
			
			
			dataObj.setTimesViewed(dataObj.getTimesViewed()+1);
			System.out.println(dataObj);
			
			ObjectMapper om = new ObjectMapper();
			Resume mapperObject= om.readValue(dataObj.getResumeText(), Resume.class);
			
			System.out.println(mapperObject);
			em.merge(dataObj);
			em.getTransaction().commit();
			em.close();
		}

		
		
		
//		JobSeeker findJobSeekerByUserName(String name) {
//			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//			em.getTransaction().begin();
//			JobSeeker js = em.find(JobSeeker.class, name);
//			
//			em.getTransaction().commit();
//			em.close();
//			// PersistenceManager.INSTANCE.close();
//			return js;
//		}
		public  JobSeeker jobSeekerUsername(String name) {
			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<JobSeeker> cq = cb.createQuery(JobSeeker.class);
			Root<JobSeeker> root = cq.from(JobSeeker.class);
			cq.select(root);
			
			Metamodel m = em.getMetamodel();
			EntityType<JobSeeker> JsEntity = m.entity(JobSeeker.class);
			Expression username_exp = root.get(JsEntity.getSingularAttribute("user_name"));
			
			Predicate p1 = cb.equal(username_exp, name);
			cq.where(p1);
			
			JobSeeker js = em.createQuery(cq).getSingleResult();
			em.getTransaction().commit();
			em.close();
			// PersistenceManager.INSTANCE.close();
			return js;
		}
		
		@Test
		public void jobSeekerUsernameFind() {
			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			JobSeeker js = new JobSeeker();
			js = em.find(JobSeeker.class, "d1");
			System.out.println(js);
			em.getTransaction().commit();
			em.close();
			// PersistenceManager.INSTANCE.close();
		}
		@Test
		public  void findJobSeekerByUsername() {
			EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			JobSeeker js =em.find(JobSeeker.class, "d1");
			em.getTransaction().commit();
			em.close();
			System.out.println(js);

		}
		
		@Test
		public void jobSeekerFindResume1() {
			ResumeDAO rDAO = new ResumeDAO();
			JobSeekerDAO jDAO = new JobSeekerDAO();
			JobSeeker js = new JobSeeker();
			js.setUser_name("r99");
			jDAO.findJobSeekerByUsername(js);
			System.out.println(js);
			
			
		}
		
		@Test
		public void viewresumeEmp() {
			ResumeDAO rDAO = new ResumeDAO();
			JobSeeker js = new JobSeeker();
			js.setUser_name("d2");
			Resume res = rDAO.viewResumeEmployer(js);
			System.out.println(res);
		
		}
		
		@Test
		public void viewresumeEmp1() {
			JobSeeker js = new JobSeeker();
			js.setUser_name("d2");
			js.setResumeCreated(false);
			EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
			em.getTransaction().begin();
			em.merge(js);
			em.getTransaction().commit();
			em.close();
		
		}


}
