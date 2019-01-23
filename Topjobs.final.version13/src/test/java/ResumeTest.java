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
import com.topjobs.domain.Address;
import com.topjobs.domain.JobSeeker;
import com.topjobs.domain.JobSeekerMarks;
import com.topjobs.domain.Resume;
import com.topjobs.domain.User;
import com.topjobs.persistence.PersistenceManager;


class ResumeTest {

	@Test
void resumeInsert() throws JsonProcessingException {
		Resume rs = new Resume();
		
		JobSeeker js = new JobSeeker();

		js.setUserName("d99");
//		js.setUserPass("p2");
//		rs.setResumeId(352L);
		rs.setJobSeeker(js);;
		rs.setEmail("diwakar94@gmail.com");
		rs.setContactNumber("8447849901");
		
		Address addr = new Address();
		addr.setAddressLine("3951. Ahiran Street");
		addr.setCity("Delhi");
		addr.setState("Delhi");
		addr.setPin(110006);
		
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
		Expression resume_exp = root.get(rEntity.getSingularAttribute("user"));
		
		User user = new User();
		user.setUserName("d1");
		
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

}
