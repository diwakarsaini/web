import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.topjobs.domain.Job;
import com.topjobs.persistence.PersistenceManager;

class jobTest {
	
	@Test
	public void findJobByID() {
		Job obj = new Job();
		obj.setJobId(105L);
		
		EntityManager em= PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		obj = em.find(Job.class, obj.getJobId());
		em.getTransaction().commit();
		em.close();
		System.out.println(obj);
	}
}

