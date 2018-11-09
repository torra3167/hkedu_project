package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginCommand implements Serializable {
	private String email;
	private String pw;
	private boolean rememberEmail;
	
	
	public boolean isRememberEmail() {
		return rememberEmail;
	}
	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
