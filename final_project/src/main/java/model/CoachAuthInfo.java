package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CoachAuthInfo implements Serializable {
	
	private String coachEmail;
	private String coachName;
	
	public CoachAuthInfo() {
		
	}
	public CoachAuthInfo(String coachEmail, String coachName) {
		this.coachEmail = coachEmail;
		this.coachName = coachName;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	
	
}
