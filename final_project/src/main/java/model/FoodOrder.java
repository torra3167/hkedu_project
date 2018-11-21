package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodOrder implements Serializable {
	private String memberEmail;
	private int foodOrderReceiverNo;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private int foodOrderPrice;
	private int foodOrderQuant;
	private String foodOrderName;
	private String foodOrderStored;
	
	public FoodOrder() {
	}
	
	
	

	//구매자이메일,식품번호,판매자이메일, 카테고리A,카테고리B,카테고리C, 가격, 갯수,식품이름, 이미지
	public FoodOrder(String memberEmail, int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo,
			int foodOrderPrice, int foodOrderQuant, String foodOrderName, String foodOrderStored) {
		super();
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodOrderPrice = foodOrderPrice;
		this.foodOrderQuant = foodOrderQuant;
		this.foodOrderName = foodOrderName;
		this.foodOrderStored = foodOrderStored;
	}





	public String getFoodOrderStored() {
		return foodOrderStored;
	}




	public void setFoodOrderStored(String foodOrderStored) {
		this.foodOrderStored = foodOrderStored;
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
	public int getFoodOrderReceiverNo() {
		return foodOrderReceiverNo;
	}
	public void setFoodOrderReceiverNo(int foodOrderReceiverNo) {
		this.foodOrderReceiverNo = foodOrderReceiverNo;
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
	public int getFoodOrderPrice() {
		return foodOrderPrice;
	}
	public void setFoodOrderPrice(int foodOrderPrice) {
		this.foodOrderPrice = foodOrderPrice;
	}
	
	public int getFoodOrderQuant() {
		return foodOrderQuant;
	}
	public void setFoodOrderQuant(int foodOrderQuant) {
		this.foodOrderQuant = foodOrderQuant;
	}
	public String getFoodOrderName() {
		return foodOrderName;
	}
	public void setFoodOrderName(String foodOrderName) {
		this.foodOrderName = foodOrderName;
	}
	
	
}
