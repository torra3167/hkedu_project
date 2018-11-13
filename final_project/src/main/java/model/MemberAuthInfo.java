package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberAuthInfo implements Serializable{
	private String memberEmail;
	private String memberName;
	private String memberPhone;
	private String memberPass;
	private String memberAddr1;
	private String memberAddr2;
	private int memberAddrNo;
	private String memberDivide;
	
	public MemberAuthInfo() {}
	
	public MemberAuthInfo(String memberEmail, String memberName, String memberPhone, String memberPass, String memberAddr1,
			String memberAddr2, int memberAddrNo, String memberDivide) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberPass = memberPass;
		this.memberAddr1 = memberAddr1;
		this.memberAddr2 = memberAddr2;
		this.memberAddrNo = memberAddrNo;
		this.memberDivide = memberDivide;
	}

	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberAddr1() {
		return memberAddr1;
	}
	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public int getMemberAddrNo() {
		return memberAddrNo;
	}
	public void setMemberAddrNo(int memberAddrNo) {
		this.memberAddrNo = memberAddrNo;
	}

	public String getMemberDivide() {
		return memberDivide;
	}

	public void setMemberDivide(String memberDivide) {
		this.memberDivide = memberDivide;
	}

}
