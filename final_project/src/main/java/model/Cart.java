package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	private int foodNo;
	private String foodName;
	private int foodPrice;
	private String foodImage;
	//식품재고를위한 갯수
	private int foodQty;
	//전체상품갯수
	private int demandQty;

	
	
	public Cart() {
	}
	public Cart(int foodNo, String foodName, int foodPrice, String foodImage, int demandQty) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.demandQty = demandQty;
	}
	
	
	
	
	
	public int getDemandQty() {
		return demandQty;
	}
	public void setDemandQty(int demandQty) {
		this.demandQty = demandQty;
	}
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(int foodQty) {
		this.foodQty = foodQty;
	}
	
	
}
