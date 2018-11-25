package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProFoodPay implements Serializable{
	
	private int proFoodPayNo;
	private String memberEmail;
	private int proFoodOrderReceiverNo;
	private int proFoodPayPrice;
	private String proFoodPayDivide;
	private int proFoodPayCardNo;
	private int proFoodPayCardM;
	private int proFoodPayCardY;
	private int proFoodPayCardCvc;
	private String proFoodPayDate;
	
	public ProFoodPay() {
	}
	

	public ProFoodPay(String memberEmail, int proFoodOrderReceiverNo, int proFoodPayPrice, String proFoodPayDivide,
			int proFoodPayCardNo, int proFoodPayCardM, int proFoodPayCardY, int proFoodPayCardCvc,
			String proFoodPayDate) {
		super();
		this.memberEmail = memberEmail;
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
		this.proFoodPayPrice = proFoodPayPrice;
		this.proFoodPayDivide = proFoodPayDivide;
		this.proFoodPayCardNo = proFoodPayCardNo;
		this.proFoodPayCardM = proFoodPayCardM;
		this.proFoodPayCardY = proFoodPayCardY;
		this.proFoodPayCardCvc = proFoodPayCardCvc;
		this.proFoodPayDate = proFoodPayDate;
	}


	public int getProFoodPayNo() {
		return proFoodPayNo;
	}

	public void setProFoodPayNo(int proFoodPayNo) {
		this.proFoodPayNo = proFoodPayNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getProFoodOrderReceiverNo() {
		return proFoodOrderReceiverNo;
	}

	public void setProFoodOrderReceiverNo(int proFoodOrderReceiverNo) {
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
	}

	public int getProFoodPayPrice() {
		return proFoodPayPrice;
	}

	public void setProFoodPayPrice(int proFoodPayPrice) {
		this.proFoodPayPrice = proFoodPayPrice;
	}

	public String getProFoodPayDivide() {
		return proFoodPayDivide;
	}

	public void setProFoodPayDivide(String proFoodPayDivide) {
		this.proFoodPayDivide = proFoodPayDivide;
	}

	public int getProFoodPayCardNo() {
		return proFoodPayCardNo;
	}

	public void setProFoodPayCardNo(int proFoodPayCardNo) {
		this.proFoodPayCardNo = proFoodPayCardNo;
	}

	public int getProFoodPayCardM() {
		return proFoodPayCardM;
	}

	public void setProFoodPayCardM(int proFoodPayCardM) {
		this.proFoodPayCardM = proFoodPayCardM;
	}

	public int getProFoodPayCardY() {
		return proFoodPayCardY;
	}

	public void setProFoodPayCardY(int proFoodPayCardY) {
		this.proFoodPayCardY = proFoodPayCardY;
	}

	public int getProFoodPayCardCvc() {
		return proFoodPayCardCvc;
	}

	public void setProFoodPayCardCvc(int proFoodPayCardCvc) {
		this.proFoodPayCardCvc = proFoodPayCardCvc;
	}

	public String getProFoodPayDate() {
		return proFoodPayDate;
	}

	public void setProFoodPayDate(String proFoodPayDate) {
		this.proFoodPayDate = proFoodPayDate;
	}
	
	
	
	
}
