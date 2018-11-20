package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodPay implements Serializable{
	private int foodPayNo;
	private String memberEmail;
	private int foodOrderReceiverNo;
	private int foodPayPrice;
	private String foodPayCard;
	private String foodPayCash;
	private int foodPayCardNo;
	private int foodPayCardM;
	private int foodPayCardY;
	private int foodPayCardCvc;
	private String foodPayDate;
	
	
	public FoodPay() {
	}


	public FoodPay(int foodPayNo, String memberEmail, int foodOrderReceiverNo, int foodPayPrice, String foodPayCard,
			String foodPayCash, int foodPayCardNo, int foodPayCardM, int foodPayCardY, int foodPayCardCvc,
			String foodPayDate) {
		this.foodPayNo = foodPayNo;
		this.memberEmail = memberEmail;
		this.foodOrderReceiverNo = foodOrderReceiverNo;
		this.foodPayPrice = foodPayPrice;
		this.foodPayCard = foodPayCard;
		this.foodPayCash = foodPayCash;
		this.foodPayCardNo = foodPayCardNo;
		this.foodPayCardM = foodPayCardM;
		this.foodPayCardY = foodPayCardY;
		this.foodPayCardCvc = foodPayCardCvc;
		this.foodPayDate = foodPayDate;
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


	public String getFoodPayCard() {
		return foodPayCard;
	}


	public void setFoodPayCard(String foodPayCard) {
		this.foodPayCard = foodPayCard;
	}


	public String getFoodPayCash() {
		return foodPayCash;
	}


	public void setFoodPayCash(String foodPayCash) {
		this.foodPayCash = foodPayCash;
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


	public String getFoodPayDate() {
		return foodPayDate;
	}


	public void setFoodPayDate(String foodPayDate) {
		this.foodPayDate = foodPayDate;
	}


	
	
}
