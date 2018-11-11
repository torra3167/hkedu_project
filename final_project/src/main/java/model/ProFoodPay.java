package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProFoodPay implements Serializable{
	private int proFoodPayNo;
	private String memberEmail;
	private int proFoodOrderReceiverNo;
	private int proFoodPayPrice;
	private String proFoodPayCard;
	private String proFoodPayCash;
	private int proFoodPayCardNo;
	private int proFoodPayCardM;
	private int proFoodPayCardY;
	private int proFoodPayCardCvc;
	private Date proFoodPayDate;
	public ProFoodPay() {
	}
	public ProFoodPay(int proFoodPayNo, String memberEmail, int proFoodOrderReceiverNo, int proFoodPayPrice,
			String proFoodPayCard, String proFoodPayCash, int proFoodPayCardNo, int proFoodPayCardM,
			int proFoodPayCardY, int proFoodPayCardCvc, Date proFoodPayDate) {
		this.proFoodPayNo = proFoodPayNo;
		this.memberEmail = memberEmail;
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
		this.proFoodPayPrice = proFoodPayPrice;
		this.proFoodPayCard = proFoodPayCard;
		this.proFoodPayCash = proFoodPayCash;
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
	public String getProFoodPayCard() {
		return proFoodPayCard;
	}
	public void setProFoodPayCard(String proFoodPayCard) {
		this.proFoodPayCard = proFoodPayCard;
	}
	public String getProFoodPayCash() {
		return proFoodPayCash;
	}
	public void setProFoodPayCash(String proFoodPayCash) {
		this.proFoodPayCash = proFoodPayCash;
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
	public Date getProFoodPayDate() {
		return proFoodPayDate;
	}
	public void setProFoodPayDate(Date proFoodPayDate) {
		this.proFoodPayDate = proFoodPayDate;
	}
	
	
}
