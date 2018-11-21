package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodName;
	private int foodPrice;
	private String foodImage;
	//전체상품갯수
	private int demandQty;

	
	
	
	public Cart() {
	}
	
	
	public Cart(int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo, String foodName,
			int foodPrice, String foodImage, int demandQty) {
		super();
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.demandQty = demandQty;
	}


	public Cart(int foodNo, String foodName, int foodPrice, String foodImage, int demandQty) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.demandQty = demandQty;
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

	
}
