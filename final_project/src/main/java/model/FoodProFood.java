package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodProFood implements Serializable{
	private int proFoodNo;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private int proNo;
	private String coachEmail;
	private String foodName;
	private int foodQuant;
	private String foodExpiryDate;
	private int foodSale;
	private int foodPrice;
	private int foodCarbo;
	private int foodProtein;
	private int foodFat;
	private int foodCal;
	private Long foodSize;
	private String foodOriginal;
	private String foodStored;
	
	public FoodProFood() {}

	public FoodProFood(int proFoodNo, int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo,
			int proNo, String coachEmail, String foodName, int foodQuant, String foodExpiryDate, int foodSale,
			int foodPrice, int foodCarbo, int foodProtein, int foodFat, int foodCal, Long foodSize, String foodOriginal,
			String foodStored) {
		this.proFoodNo = proFoodNo;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.foodName = foodName;
		this.foodQuant = foodQuant;
		this.foodExpiryDate = foodExpiryDate;
		this.foodSale = foodSale;
		this.foodPrice = foodPrice;
		this.foodCarbo = foodCarbo;
		this.foodProtein = foodProtein;
		this.foodFat = foodFat;
		this.foodCal = foodCal;
		this.foodSize = foodSize;
		this.foodOriginal = foodOriginal;
		this.foodStored = foodStored;
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

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodQuant() {
		return foodQuant;
	}

	public void setFoodQuant(int foodQuant) {
		this.foodQuant = foodQuant;
	}

	public String getFoodExpiryDate() {
		return foodExpiryDate;
	}

	public void setFoodExpiryDate(String foodExpiryDate) {
		this.foodExpiryDate = foodExpiryDate;
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

	public int getFoodCarbo() {
		return foodCarbo;
	}

	public void setFoodCarbo(int foodCarbo) {
		this.foodCarbo = foodCarbo;
	}

	public int getFoodProtein() {
		return foodProtein;
	}

	public void setFoodProtein(int foodProtein) {
		this.foodProtein = foodProtein;
	}

	public int getFoodFat() {
		return foodFat;
	}

	public void setFoodFat(int foodFat) {
		this.foodFat = foodFat;
	}

	public int getFoodCal() {
		return foodCal;
	}

	public void setFoodCal(int foodCal) {
		this.foodCal = foodCal;
	}

	public Long getFoodSize() {
		return foodSize;
	}

	public void setFoodSize(Long foodSize) {
		this.foodSize = foodSize;
	}

	public String getFoodOriginal() {
		return foodOriginal;
	}

	public void setFoodOriginal(String foodOriginal) {
		this.foodOriginal = foodOriginal;
	}

	public String getFoodStored() {
		return foodStored;
	}

	public void setFoodStored(String foodStored) {
		this.foodStored = foodStored;
	}
	
	

}
