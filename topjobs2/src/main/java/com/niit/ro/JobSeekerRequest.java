package com.niit.ro;

import com.niit.domain.Resume;

public class JobSeekerRequest extends UserRequest {

	private Resume resume;
	private Boolean resumeCreated;
	
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public boolean isResumeCreated() {
		return resumeCreated;
	}
	public void setResumeCreated(Boolean resumeCreated) {
		this.resumeCreated = resumeCreated;
	}
	
}
