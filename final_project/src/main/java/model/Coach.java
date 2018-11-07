package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Coach implements Serializable {

	
	private String coachEmail;
	private String coachPw;
	private String coachName;
	private String coachPhoto;
	private String coachCareer;
	
	
	public Coach() {
		
	}
	public String getCoachEmail() {
		return coachEmail;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	public String getCoachPw() {
		return coachPw;
	}
	public void setCoachPw(String coachPw) {
		this.coachPw = coachPw;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public String getCoachPhoto() {
		return coachPhoto;
	}
	public void setCoachPhoto(String coachPhoto) {
		this.coachPhoto = coachPhoto;
	}
	public String getCoachCareer() {
		return coachCareer;
	}
	public void setCoachCareer(String coachCareer) {
		this.coachCareer = coachCareer;
	}
	
	
}
