package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberProFoodOrderListCommand implements Serializable {
	private int proFodNo;
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
	private String profoodOrderName;
	
	public MemberProFoodOrderListCommand() {
		
	}
	
	public int getProFodNo() {
		return proFodNo;
	}
	public void setProFodNo(int proFodNo) {
		this.proFodNo = proFodNo;
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
	public String getProfoodOrderName() {
		return profoodOrderName;
	}
	public void setProfoodOrderName(String profoodOrderName) {
		this.profoodOrderName = profoodOrderName;
	}
	
	
}
