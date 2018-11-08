package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuthInfo implements Serializable { 

	private String email;
	private String divide;
	private String name;
	
	public  AuthInfo() {}
	
	
	public AuthInfo(String email, String divide, String name) {
		this.email = email;
		this.divide = divide;
		this.name = name;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDivide() {
		return divide;
	}
	public void setDivide(String divide) {
		this.divide = divide;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
