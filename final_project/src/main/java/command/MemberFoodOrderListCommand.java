package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberFoodOrderListCommand implements Serializable {
	private String memberEmail;
	private int foodOrderReceiverNo;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private int foodOrderPrice;
	private int foodOrderFee;
	private int foodOrderQuant;
	private String foodOrderName;
	
	public MemberFoodOrderListCommand() {
		
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
	public int getFoodOrderFee() {
		return foodOrderFee;
	}
	public void setFoodOrderFee(int foodOrderFee) {
		this.foodOrderFee = foodOrderFee;
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
