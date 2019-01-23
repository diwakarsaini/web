package com.topjobs.request;

import java.util.List;

import com.topjobs.domain.Address;
import com.topjobs.domain.JobSeekerMarks;
import com.topjobs.domain.JobSeeker;

public class ResumeRequest {
	

		private Long resumeId;
		private JobSeeker jobSeeker;
		private String email;
		private String contactNumber;
		private Address address;
		private List<String> skills;
		private JobSeekerMarks jobSeekerMarks;
		private String resumeText;
		private long timesViewed;
		public Long getResumeId() {
			return resumeId;
		}
		public void setResumeId(Long resumeId) {
			this.resumeId = resumeId;
		}
		public JobSeeker getJobSeeker() {
			return jobSeeker;
		}
		public void setJobSeeker(JobSeeker jobSeeker) {
			this.jobSeeker = jobSeeker;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public List<String> getSkills() {
			return skills;
		}
		public void setSkills(List<String> skills) {
			this.skills = skills;
		}
		public JobSeekerMarks getJobSeekerMarks() {
			return jobSeekerMarks;
		}
		public void setJobSeekerMarks(JobSeekerMarks jobSeekerMarks) {
			this.jobSeekerMarks = jobSeekerMarks;
		}
		public String getResumeText() {
			return resumeText;
		}
		public void setResumeText(String resumeText) {
			this.resumeText = resumeText;
		}
		public long getTimesViewed() {
			return timesViewed;
		}
		public void setTimesViewed(long timesViewed) {
			this.timesViewed = timesViewed;
		}
		@Override
		public String toString() {
			return "ResumeRequest [resumeId=" + resumeId + ", jobSeeker=" + jobSeeker + ", email=" + email
					+ ", contactNumber=" + contactNumber + ", address=" + address + ", skills=" + skills
					+ ", jobSeekerMarks=" + jobSeekerMarks + ", resumeText=" + resumeText + ", timesViewed="
					+ timesViewed + "]";
		}

		

}
