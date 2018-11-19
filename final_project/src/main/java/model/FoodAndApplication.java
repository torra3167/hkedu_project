package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodAndApplication implements Serializable{
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodName;
	private int foodQuant;
	private String foodExpiryDate;
	private String foodOrigin;
	private int foodSale;
	private String foodFlavor;
	private int foodPrice;
	private int foodCarbo;
	private int foodProtein;
	private int foodFat;
	private int foodCal;
	private Long foodSize;
	private String foodOriginal;
	private String foodStored;
	private String sellerName;
	private String storeName;
	private String storeTelphone;
	private String storeAddr;
	public FoodAndApplication() {
	}
	public FoodAndApplication(int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo,
			String foodName, int foodQuant, String foodExpiryDate, String foodOrigin, int foodSale, String foodFlavor,
			int foodPrice, int foodCarbo, int foodProtein, int foodFat, int foodCal, Long foodSize, String foodOriginal,
			String foodStored, String sellerName, String storeName, String storeTelphone, String storeAddr) {
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodName = foodName;
		this.foodQuant = foodQuant;
		this.foodExpiryDate = foodExpiryDate;
		this.foodOrigin = foodOrigin;
		this.foodSale = foodSale;
		this.foodFlavor = foodFlavor;
		this.foodPrice = foodPrice;
		this.foodCarbo = foodCarbo;
		this.foodProtein = foodProtein;
		this.foodFat = foodFat;
		this.foodCal = foodCal;
		this.foodSize = foodSize;
		this.foodOriginal = foodOriginal;
		this.foodStored = foodStored;
		this.sellerName = sellerName;
		this.storeName = storeName;
		this.storeTelphone = storeTelphone;
		this.storeAddr = storeAddr;
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
	public String getFoodOrigin() {
		return foodOrigin;
	}
	public void setFoodOrigin(String foodOrigin) {
		this.foodOrigin = foodOrigin;
	}
	public int getFoodSale() {
		return foodSale;
	}
	public void setFoodSale(int foodSale) {
		this.foodSale = foodSale;
	}
	public String getFoodFlavor() {
		return foodFlavor;
	}
	public void setFoodFlavor(String foodFlavor) {
		this.foodFlavor = foodFlavor;
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
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreTelphone() {
		return storeTelphone;
	}
	public void setStoreTelphone(String storeTelphone) {
		this.storeTelphone = storeTelphone;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	
	
}
