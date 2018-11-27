package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProOrder implements Serializable{
	private int proOrderNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String proOrderName;
	private int proOrderTotal;
	private String proOrderStored;
	
	
	
	
	public ProOrder() {
	}




	public ProOrder(String memberEmail, int proNo, String coachEmail, String proOrderName, int proOrderTotal,
			String proOrderStored) {
		super();
		this.memberEmail = memberEmail;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proOrderName = proOrderName;
		this.proOrderTotal = proOrderTotal;
		this.proOrderStored = proOrderStored;
	}









	public String getProOrderStored() {
		return proOrderStored;
	}




	public void setProOrderStored(String proOrderStored) {
		this.proOrderStored = proOrderStored;
	}




	public int getProOrderNo() {
		return proOrderNo;
	}




	public void setProOrderNo(int proOrderNo) {
		this.proOrderNo = proOrderNo;
	}




	public String getMemberEmail() {
		return memberEmail;
	}




	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}




	public int getProNo() {
		return proNo;
	}




	public void setProNo(int proNo) {
		this.proNo = proNo;
	}




	public String getCoachEmail() {
		return coachEmail;
	}




	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}




	public String getProOrderName() {
		return proOrderName;
	}




	public void setProOrderName(String proOrderName) {
		this.proOrderName = proOrderName;
	}




	public int getProOrderTotal() {
		return proOrderTotal;
	}




	public void setProOrderTotal(int proOrderTotal) {
		this.proOrderTotal = proOrderTotal;
	}


	
	
	
	
}
