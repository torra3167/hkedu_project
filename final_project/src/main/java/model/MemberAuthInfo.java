package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberAuthInfo implements Serializable{
	private String memberEmail;
	private String memberPw;
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public MemberAuthInfo() {}
	public MemberAuthInfo(String memberEmail, String memberPw) {
		
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

}
