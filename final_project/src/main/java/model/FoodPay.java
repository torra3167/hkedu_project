package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FoodPay implements Serializable{
	private int foodPayNo;
	private String memberEmail;
	private int foodOrderReceiverNo;
	private int foodPayPrice;
	private String foodPayDivide;
	private int foodPayCardNo;
	private int foodPayCardM;
	private int foodPayCardY;
	private int foodPayCardCvc;
	private Date foodPayDate;

	
	public FoodPay() {
	}


	public FoodPay(int foodPayNo, String memberEmail, int foodOrderReceiverNo, int foodPayPrice, String foodPayDivide,
			int foodPayCardNo, int foodPayCardM, int foodPayCardY, int foodPayCardCvc) {
		super();
		this.foodPayNo = foodPayNo;
		this.memberEmail = memberEmail;
		this.foodOrderReceiverNo = foodOrderReceiverNo;
		this.foodPayPrice = foodPayPrice;
		this.foodPayDivide = foodPayDivide;
		this.foodPayCardNo = foodPayCardNo;
		this.foodPayCardM = foodPayCardM;
		this.foodPayCardY = foodPayCardY;
		this.foodPayCardCvc = foodPayCardCvc;
	}


	public int getFoodPayNo() {
		return foodPayNo;
	}


	public void setFoodPayNo(int foodPayNo) {
		this.foodPayNo = foodPayNo;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public int getFoodOrderReceiverNo() {
		return foodOrderReceiverNo;
	}


	public void setFoodOrderReceiverNo(int foodOrderReceiverNo) {
		this.foodOrderReceiverNo = foodOrderReceiverNo;
	}


	public int getFoodPayPrice() {
		return foodPayPrice;
	}


	public void setFoodPayPrice(int foodPayPrice) {
		this.foodPayPrice = foodPayPrice;
	}


	public String getFoodPayDivide() {
		return foodPayDivide;
	}


	public void setFoodPayDivide(String foodPayDivide) {
		this.foodPayDivide = foodPayDivide;
	}


	public int getFoodPayCardNo() {
		return foodPayCardNo;
	}


	public void setFoodPayCardNo(int foodPayCardNo) {
		this.foodPayCardNo = foodPayCardNo;
	}


	public int getFoodPayCardM() {
		return foodPayCardM;
	}


	public void setFoodPayCardM(int foodPayCardM) {
		this.foodPayCardM = foodPayCardM;
	}


	public int getFoodPayCardY() {
		return foodPayCardY;
	}


	public void setFoodPayCardY(int foodPayCardY) {
		this.foodPayCardY = foodPayCardY;
	}


	public int getFoodPayCardCvc() {
		return foodPayCardCvc;
	}


	public void setFoodPayCardCvc(int foodPayCardCvc) {
		this.foodPayCardCvc = foodPayCardCvc;
	}


	public Date getFoodPayDate() {
		return foodPayDate;
	}


	public void setFoodPayDate(Date foodPayDate) {
		this.foodPayDate = foodPayDate;
	}


	

	
	
	
}
