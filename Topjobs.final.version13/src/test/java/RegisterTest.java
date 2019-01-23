import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

import com.topjobs.domain.Employer;
import com.topjobs.domain.User;
import com.topjobs.domain.UserRole;
import com.topjobs.exceptions.RegistrationFailedException;
import com.topjobs.persistence.PersistenceManager;

class RegisterTest {

	@Test
	void registerUser1() {
		Employer emp = new Employer();
		emp.setUserName("diwakar1@gmail.com");
		emp.setUserPass("diwakar1");
		emp.setIsSupervisor(true);
		emp.setIsActive(true);
		emp.setfName("Diwakar");
		emp.setlName("Saini");
		
		UserRole ur = new UserRole();
		ur.setRoleName("Employer");
		ur.setUserName("diwakar1@gmail.com");
		Set<User> userSet = new HashSet<>();
		userSet.add(emp);
		
		emp.setUserRole(ur);
		
		registerUser(emp);
	}
	
	
	
	
	
	void registerUser(User user) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		user = em.find(Employer.class, "diwakaar");
		System.out.println(user);
//		em.remove(user);
		em.getTransaction().commit();
		em.close();
		
		
		
		
//		try {
//			createConnection(request);
//			request.getRequestDispatcher("RegistrationSuccessful").forward(request, response);
//			
//		} catch (RegistrationFailedException e) {
//			request.setAttribute("exception", e.getMessage());
//			request.getRequestDispatcher("Homepage").forward(request, response);
//		}
//		
//
//	}
//
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request,response);
//	}
//
//	//JDBC Inserts
//	private void createConnection(HttpServletRequest req) throws RegistrationFailedException {

//		String user_insert = "Insert into users(user_name,user_pass) VALUES(?,?)";
//		String role_insert = "Insert into user_roles(user_name,role_name) VALUES(?,?)";
//		try(	Connection con = getConnection();
//				PreparedStatement user_insert_prepared =  con.prepareStatement(user_insert);
//				PreparedStatement role_insert_prepared = con.prepareStatement(role_insert); ) {
//			try {
//				con.setAutoCommit(false);
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//
//			try {
//
//
//
//				user_insert_prepared.setString(1, diwakar);//email
//				user_insert_prepared.setString(2, req.getParameter("pswd"));//password
//
//				role_insert_prepared.setString(1, req.getParameter("email"));//email
//				role_insert_prepared.setString(2, req.getParameter("role"));//role
//
//				user_insert_prepared.executeUpdate();
//				System.out.println("User is Created");
//				System.out.println(req.getParameter("email") + "  " + req.getParameter("pswd"));
//
//				role_insert_prepared.executeUpdate();
//				System.out.println("Role is inserted");
//				System.out.println(req.getParameter("email") + "  " + req.getParameter("role"));
//				user_insert_prepared.close();
//				role_insert_prepared.close();
//				con.commit();
//
//			} catch (SQLException e) {
//				try {
//					con.rollback();
//					throw new RegistrationFailedException("Registration failed. User already exist.");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//
//				}
//				e.printStackTrace();
//
//
//			}
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//	}
//
//		//Connection object
//		private Connection getConnection() {
//			final String DBCONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
//			Connection con = null;
//
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");        	//load the class
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			}
//
//			try {
//				con = DriverManager.getConnection(DBCONNECTION, "topjobs", "server99"); 
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return con;
//		}
//
//	}
		
		
	}
	
	

}
