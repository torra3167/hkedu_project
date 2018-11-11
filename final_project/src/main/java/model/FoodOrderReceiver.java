package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodOrderReceiver implements Serializable{
	private int foodOrderReceiverNo;
	private String memberEmail;
	private String proFoodOrderReceiverName;
	private int foodOrderReceiverPhone;
	private String foodOrderReceiverAddr1;
	private String foodOrderReceiverAddr2;
	private int foodOrderReceiverAddrno;
	private int foodOrderReceiverTotal;
	public FoodOrderReceiver() {
	}
	public FoodOrderReceiver(int foodOrderReceiverNo, String memberEmail, String proFoodOrderReceiverName,
			int foodOrderReceiverPhone, String foodOrderReceiverAddr1, String foodOrderReceiverAddr2,
			int foodOrderReceiverAddrno, int foodOrderReceiverTotal) {
		this.foodOrderReceiverNo = foodOrderReceiverNo;
		this.memberEmail = memberEmail;
		this.proFoodOrderReceiverName = proFoodOrderReceiverName;
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
	public String getProFoodOrderReceiverName() {
		return proFoodOrderReceiverName;
	}
	public void setProFoodOrderReceiverName(String proFoodOrderReceiverName) {
		this.proFoodOrderReceiverName = proFoodOrderReceiverName;
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
