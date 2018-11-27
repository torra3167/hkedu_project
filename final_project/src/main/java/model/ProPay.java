package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProPay implements Serializable{
	
	private int proPayNo;
	private int proOrderNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int proPayPrice;
	private String proPayDivide;
	private int proPayCardNo;
	private int proPayCardM;
	private int proPayCardY;
	private int proPayCardCvc;
	private String proPayDate;
	
	public ProPay() {
	}

	
	
	public String getCoachEmail() {
		return coachEmail;
	}



	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}



	public int getProPayNo() {
		return proPayNo;
	}

	public void setProPayNo(int proPayNo) {
		this.proPayNo = proPayNo;
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

	public int getProPayPrice() {
		return proPayPrice;
	}

	public void setProPayPrice(int proPayPrice) {
		this.proPayPrice = proPayPrice;
	}

	public String getProPayDivide() {
		return proPayDivide;
	}

	public void setProPayDivide(String proPayDivide) {
		this.proPayDivide = proPayDivide;
	}

	public int getProPayCardNo() {
		return proPayCardNo;
	}

	public void setProPayCardNo(int proPayCardNo) {
		this.proPayCardNo = proPayCardNo;
	}

	public int getProPayCardM() {
		return proPayCardM;
	}

	public void setProPayCardM(int proPayCardM) {
		this.proPayCardM = proPayCardM;
	}

	public int getProPayCardY() {
		return proPayCardY;
	}

	public void setProPayCardY(int proPayCardY) {
		this.proPayCardY = proPayCardY;
	}

	public int getProPayCardCvc() {
		return proPayCardCvc;
	}

	public void setProPayCardCvc(int proPayCardCvc) {
		this.proPayCardCvc = proPayCardCvc;
	}

	public String getProPayDate() {
		return proPayDate;
	}

	public void setProPayDate(String proPayDate) {
		this.proPayDate = proPayDate;
	}
	

	
	
	
	
}
