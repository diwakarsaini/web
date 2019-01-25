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
import com.topjobs.dao.JobSeekerDAO;
import com.topjobs.dao.ResumeDAO;
import com.topjobs.domain.Address;
import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.JobSeekerMarks;
import com.topjobs.domain.Resume;
import com.topjobs.domain.User;
import com.topjobs.persistence.PersistenceManager;


class ResumeTest {

	@Test
void resumeInsert() throws JsonProcessingException {
		Resume rs = new Resume();
		
		JobSeeker js =jobSeekerUsername("b99");
		
		
		

		rs.setResumeId(902L);
		rs.setJobSeeker(js);;
		rs.setEmail("diwakar@gmail.com");
		rs.setContactNumber("8447849901");
		
		Address addr = new Address();
		addr.setAddressLine("3951. Ahiran Street");
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
		
		JobSeekerMarks jsmarks = new JobSeekerMarks();
		jsmarks.setMarks10(98.7);
		jsmarks.setMarks12(99.5);
		jsmarks.setGradMarks(99.99);
		
		rs.setJobSeekerMarks(jsmarks);
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
		user.setUserName("d9");
		
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

	
	
	
//	JobSeeker findJobSeekerByUserName(String name) {
//		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//		em.getTransaction().begin();
//		JobSeeker js = em.find(JobSeeker.class, name);
//		
//		em.getTransaction().commit();
//		em.close();
//		// PersistenceManager.INSTANCE.close();
//		return js;
//	}
	public  JobSeeker jobSeekerUsername(String name) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobSeeker> cq = cb.createQuery(JobSeeker.class);
		Root<JobSeeker> root = cq.from(JobSeeker.class);
		cq.select(root);
		
		Metamodel m = em.getMetamodel();
		EntityType<JobSeeker> JsEntity = m.entity(JobSeeker.class);
		Expression username_exp = root.get(JsEntity.getSingularAttribute("userName"));
		
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
		js = em.find(JobSeeker.class, "b99");
		System.out.println(js);
		em.getTransaction().commit();
		em.close();
		// PersistenceManager.INSTANCE.close();
	}
	
	@Test
	public void jobSeekerFindResume1() {
		ResumeDAO rDAO = new ResumeDAO();
		JobSeekerDAO jDAO = new JobSeekerDAO();
		JobSeeker js = new JobSeeker();
		js.setUserName("r99");
		
		jDAO.jobSeekerUsernameFind(js);
		System.out.println(js);
		
		
	}
	
	
	
	
	
	
}
