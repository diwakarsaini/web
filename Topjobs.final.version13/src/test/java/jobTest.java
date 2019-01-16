import java.util.List;

import org.junit.jupiter.api.Test;
import com.topjobs.domain.Job;
import com.topjobs.service.JobService;
import junit.framework.TestCase;

public class jobTest extends TestCase {

	@Test
	void test1() {
		JobService js = new JobService();
		List<Job> ls = js.getAllJobs();
		int x = 1;
		for(Job obj:ls) {
			System.out.print(x++);
			System.out.print("  ");
			System.out.print(obj);
			System.out.print("  ");
			
			System.out.print(obj.getUser());
			System.out.print("  ");
			
			if(obj.getUser()==null)
				System.out.println("null");
			else
				System.out.println(obj.getUser().getUserName());
		}
//		assertTrue(ls.size()>0);
	}
	
}
