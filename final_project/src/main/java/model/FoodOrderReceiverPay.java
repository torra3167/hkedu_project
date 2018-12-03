package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodOrderReceiverPay implements Serializable{
	private int rownum;
	private String foodOrderName;
	private int foodOrderQuant;
	private int foodPayPrice;
	private String foodPayDate;
	private int foodQuant;
	public FoodOrderReceiverPay() {
	}
	public FoodOrderReceiverPay(int rownum, String foodOrderName, int foodOrderQuant, int foodPayPrice,
			String foodPayDate, int foodQuant) {
		this.rownum = rownum;
		this.foodOrderName = foodOrderName;
		this.foodOrderQuant = foodOrderQuant;
		this.foodPayPrice = foodPayPrice;
		this.foodPayDate = foodPayDate;
		this.foodQuant = foodQuant;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getFoodOrderName() {
		return foodOrderName;
	}
	public void setFoodOrderName(String foodOrderName) {
		this.foodOrderName = foodOrderName;
	}
	public int getFoodOrderQuant() {
		return foodOrderQuant;
	}
	public void setFoodOrderQuant(int foodOrderQuant) {
		this.foodOrderQuant = foodOrderQuant;
	}
	public int getFoodPayPrice() {
		return foodPayPrice;
	}
	public void setFoodPayPrice(int foodPayPrice) {
		this.foodPayPrice = foodPayPrice;
	}
	public String getFoodPayDate() {
		return foodPayDate;
	}
	public void setFoodPayDate(String foodPayDate) {
		this.foodPayDate = foodPayDate;
	}
	public int getFoodQuant() {
		return foodQuant;
	}
	public void setFoodQuant(int foodQuant) {
		this.foodQuant = foodQuant;
	}
	
	
}
