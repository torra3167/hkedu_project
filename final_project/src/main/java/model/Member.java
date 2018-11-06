package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private Long id;
	private String email;
	private String pw;
	private String name;
	private Date regDate;
	
	
	
	public Member() {
	}
	
	public Member(Long id, String email, String pw, String name, Date regDate) {
		
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
