package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodAppliReview implements Serializable{
	private int foodNo;
	private String sellerEmail;
	private int foodCatCNo;
	private String foodName;
	private int foodSale;
	private int foodPrice;
	private String foodStored;
	private String storeName;
	private int countFoodReviewNo;
	public FoodAppliReview() {
	}
	public FoodAppliReview(int foodNo, String sellerEmail, int foodCatCNo, String foodName, int foodSale, int foodPrice,
			String foodStored, String storeName, int countFoodReviewNo) {
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatCNo = foodCatCNo;
		this.foodName = foodName;
		this.foodSale = foodSale;
		this.foodPrice = foodPrice;
		this.foodStored = foodStored;
		this.storeName = storeName;
		this.countFoodReviewNo = countFoodReviewNo;
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
	public int getFoodCatCNo() {
		return foodCatCNo;
	}
	public void setFoodCatCNo(int foodCatCNo) {
		this.foodCatCNo = foodCatCNo;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodSale() {
		return foodSale;
	}
	public void setFoodSale(int foodSale) {
		this.foodSale = foodSale;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodStored() {
		return foodStored;
	}
	public void setFoodStored(String foodStored) {
		this.foodStored = foodStored;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getCountFoodReviewNo() {
		return countFoodReviewNo;
	}
	public void setCountFoodReviewNo(int countFoodReviewNo) {
		this.countFoodReviewNo = countFoodReviewNo;
	}
}

