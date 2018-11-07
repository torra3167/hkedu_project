package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CoachLoginCommand implements Serializable {
	
	private String coachEmail;
	private String coachPw;
	private boolean rememberEmail;
	
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
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	
}
