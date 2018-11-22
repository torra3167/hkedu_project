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
	private int proFoodOrderFee;
	private String proFoodOrderProduct;
	private int proFoodOrderQuant;
	private int proFoodOrderPrice;
	private String proFoodOrderName;
	
	public ProFoodOrder() {
	}
	public ProFoodOrder(int proFoodNo, int foodNo, String sellerEmail, String memberEmail, int proFoodOrderReceiverNo,
			int foodCatANo, int foodCatBNo, int foodCatCNo, int proFoodOrderFee, String proFoodOrderProduct,
			int proFoodOrderQuant, int proFoodOrderPrice, String proFoodOrderName) {
		this.proFoodNo = proFoodNo;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.memberEmail = memberEmail;
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.proFoodOrderFee = proFoodOrderFee;
		this.proFoodOrderProduct = proFoodOrderProduct;
		this.proFoodOrderQuant = proFoodOrderQuant;
		this.proFoodOrderPrice = proFoodOrderPrice;
		this.proFoodOrderName = proFoodOrderName;
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
	public int getProFoodOrderFee() {
		return proFoodOrderFee;
	}
	public void setProFoodOrderFee(int proFoodOrderFee) {
		this.proFoodOrderFee = proFoodOrderFee;
	}
	public String getProFoodOrderProduct() {
		return proFoodOrderProduct;
	}
	public void setProFoodOrderProduct(String proFoodOrderProduct) {
		this.proFoodOrderProduct = proFoodOrderProduct;
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
	public String getProFoodOrderName() {
		return proFoodOrderName;
	}
	public void setProFoodOrderName(String proFoodOrderName) {
		this.proFoodOrderName = proFoodOrderName;
	}
	
	
}
