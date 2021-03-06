package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodOrderReceiver implements Serializable{
	
	private int foodOrderReceiverNo;
	private String memberEmail;
	private String foodOrderReceiverName;
	private int foodOrderReceiverPhone;
	private String foodOrderReceiverAddr1;
	private String foodOrderReceiverAddr2;
	private int foodOrderReceiverAddrno;
	private int foodOrderReceiverTotal;

	public FoodOrderReceiver() {
	}
	
	
	public FoodOrderReceiver(String memberEmail, int foodOrderReceiverTotal) {
		this.memberEmail = memberEmail;
		this.foodOrderReceiverTotal = foodOrderReceiverTotal;
	}


	public FoodOrderReceiver(int foodOrderReceiverNo, String memberEmail, String foodOrderReceiverName,
			int foodOrderReceiverPhone, String foodOrderReceiverAddr1, String foodOrderReceiverAddr2,
			int foodOrderReceiverAddrno, int foodOrderReceiverTotal) {
		this.foodOrderReceiverNo = foodOrderReceiverNo;
		this.memberEmail = memberEmail;
		this.foodOrderReceiverName = foodOrderReceiverName;
		this.foodOrderReceiverPhone = foodOrderReceiverPhone;
		this.foodOrderReceiverAddr1 = foodOrderReceiverAddr1;
		this.foodOrderReceiverAddr2 = foodOrderReceiverAddr2;
		this.foodOrderReceiverAddrno = foodOrderReceiverAddrno;
		this.foodOrderReceiverTotal = foodOrderReceiverTotal;
	}
	public int getFoodOrderReceiverNo() {
		return foodOrderReceiverNo;
	}
	public void setFoodOrderReceiverNo(int foodOrderReceiverNo) {
		this.foodOrderReceiverNo = foodOrderReceiverNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	public String getFoodOrderReceiverName() {
		return foodOrderReceiverName;
	}


	public void setFoodOrderReceiverName(String foodOrderReceiverName) {
		this.foodOrderReceiverName = foodOrderReceiverName;
	}


	public int getFoodOrderReceiverPhone() {
		return foodOrderReceiverPhone;
	}
	public void setFoodOrderReceiverPhone(int foodOrderReceiverPhone) {
		this.foodOrderReceiverPhone = foodOrderReceiverPhone;
	}
	public String getFoodOrderReceiverAddr1() {
		return foodOrderReceiverAddr1;
	}
	public void setFoodOrderReceiverAddr1(String foodOrderReceiverAddr1) {
		this.foodOrderReceiverAddr1 = foodOrderReceiverAddr1;
	}
	public String getFoodOrderReceiverAddr2() {
		return foodOrderReceiverAddr2;
	}
	public void setFoodOrderReceiverAddr2(String foodOrderReceiverAddr2) {
		this.foodOrderReceiverAddr2 = foodOrderReceiverAddr2;
	}
	public int getFoodOrderReceiverAddrno() {
		return foodOrderReceiverAddrno;
	}
	public void setFoodOrderReceiverAddrno(int foodOrderReceiverAddrno) {
		this.foodOrderReceiverAddrno = foodOrderReceiverAddrno;
	}
	public int getFoodOrderReceiverTotal() {
		return foodOrderReceiverTotal;
	}
	public void setFoodOrderReceiverTotal(int foodOrderReceiverTotal) {
		this.foodOrderReceiverTotal = foodOrderReceiverTotal;
	}
	
	
}
