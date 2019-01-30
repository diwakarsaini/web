package com.niit.ro;

import com.niit.domain.User;
import com.niit.domain.UserRole;

public class UserRequest {
		private String user_name;
		private String user_pass;
		private String fname;
		private String lname;
		private UserRole userRole;

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getUser_pass() {
			return user_pass;
		}

		public void setUser_pass(String user_pass) {
			this.user_pass = user_pass;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public UserRole getUserRole() {
			return userRole;
		}

		public void setUserRole(UserRole userRole) {
			this.userRole = userRole;
		}

		
}
