package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProFoodOrder implements Serializable{
	private int proFoodNo;
	private int foodNo;
	private String sellerEmail;
	private String memberEmail;
	private int proFoodOrderReceiverNo;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private int proNo;
	private String coachEmail;
	private int proFoodOrderPrice;
	private int proFoodOrderQuant;
	private String proFoodOrderName;
	private String proFoodOrderStored;
	
	
	
	public ProFoodOrder() {
	}


	public ProFoodOrder(int proFoodNo, int foodNo, String sellerEmail, String memberEmail, int foodCatANo,
			int foodCatBNo, int foodCatCNo, int proNo, String coachEmail, int proFoodOrderPrice, int proFoodOrderQuant,
			String proFoodOrderName, String proFoodOrderStored) {
		super();
		this.proFoodNo = proFoodNo;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.memberEmail = memberEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proFoodOrderPrice = proFoodOrderPrice;
		this.proFoodOrderQuant = proFoodOrderQuant;
		this.proFoodOrderName = proFoodOrderName;
		this.proFoodOrderStored = proFoodOrderStored;
	}













	public String getCoachEmail() {
		return coachEmail;
	}


	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}


	public int getProFoodNo() {
		return proFoodNo;
	}

	public void setProFoodNo(int proFoodNo) {
		this.proFoodNo = proFoodNo;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
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

	public int getFoodCatANo() {
		return foodCatANo;
	}

	public void setFoodCatANo(int foodCatANo) {
		this.foodCatANo = foodCatANo;
	}

	public int getFoodCatBNo() {
		return foodCatBNo;
	}

	public void setFoodCatBNo(int foodCatBNo) {
		this.foodCatBNo = foodCatBNo;
	}

	public int getFoodCatCNo() {
		return foodCatCNo;
	}

	public void setFoodCatCNo(int foodCatCNo) {
		this.foodCatCNo = foodCatCNo;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	

	public String getProFoodOrderName() {
		return proFoodOrderName;
	}

	public void setProFoodOrderName(String proFoodOrderName) {
		this.proFoodOrderName = proFoodOrderName;
	}

	public int getProFoodOrderQuant() {
		return proFoodOrderQuant;
	}

	public void setProFoodOrderQuant(int proFoodOrderQuant) {
		this.proFoodOrderQuant = proFoodOrderQuant;
	}

	public int getProFoodOrderPrice() {
		return proFoodOrderPrice;
	}

	public void setProFoodOrderPrice(int proFoodOrderPrice) {
		this.proFoodOrderPrice = proFoodOrderPrice;
	}

	public String getProFoodOrderStored() {
		return proFoodOrderStored;
	}

	public void setProFoodOrderStored(String proFoodOrderStored) {
		this.proFoodOrderStored = proFoodOrderStored;
	}
	
	
	
}
