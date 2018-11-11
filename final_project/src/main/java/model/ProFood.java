package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProFood implements Serializable{
	private int proFoodNo;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String proFoodName;
	private int proFoodQuant;
	private Date proFoodExpiryDate;
	private String proFoodOrigin;
	private int proFoodSale;
	private String proFoodFlavor;
	private int proFoodPrice;
	private int proFoodCarbo;
	private int proFoodProt;
	private int proFoodFat;
	private String proFoodImage;
	private int proFoodCal;
	private int proNo;
	private String coachEmail;
	
	public ProFood() {
		super();
	}
	public ProFood(int proFoodNo, int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo,
			String proFoodName, int proFoodQuant, Date proFoodExpiryDate, String proFoodOrigin, int proFoodSale,
			String proFoodFlavor, int proFoodPrice, int proFoodCarbo, int proFoodProt, int proFoodFat,
			String proFoodImage, int proFoodCal, int proNo, String coachEmail) {
		super();
		this.proFoodNo = proFoodNo;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.proFoodName = proFoodName;
		this.proFoodQuant = proFoodQuant;
		this.proFoodExpiryDate = proFoodExpiryDate;
		this.proFoodOrigin = proFoodOrigin;
		this.proFoodSale = proFoodSale;
		this.proFoodFlavor = proFoodFlavor;
		this.proFoodPrice = proFoodPrice;
		this.proFoodCarbo = proFoodCarbo;
		this.proFoodProt = proFoodProt;
		this.proFoodFat = proFoodFat;
		this.proFoodImage = proFoodImage;
		this.proFoodCal = proFoodCal;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
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
	public String getProFoodName() {
		return proFoodName;
	}
	public void setProFoodName(String proFoodName) {
		this.proFoodName = proFoodName;
	}
	public int getProFoodQuant() {
		return proFoodQuant;
	}
	public void setProFoodQuant(int proFoodQuant) {
		this.proFoodQuant = proFoodQuant;
	}
	public Date getProFoodExpiryDate() {
		return proFoodExpiryDate;
	}
	public void setProFoodExpiryDate(Date proFoodExpiryDate) {
		this.proFoodExpiryDate = proFoodExpiryDate;
	}
	public String getProFoodOrigin() {
		return proFoodOrigin;
	}
	public void setProFoodOrigin(String proFoodOrigin) {
		this.proFoodOrigin = proFoodOrigin;
	}
	public int getProFoodSale() {
		return proFoodSale;
	}
	public void setProFoodSale(int proFoodSale) {
		this.proFoodSale = proFoodSale;
	}
	public String getProFoodFlavor() {
		return proFoodFlavor;
	}
	public void setProFoodFlavor(String proFoodFlavor) {
		this.proFoodFlavor = proFoodFlavor;
	}
	public int getProFoodPrice() {
		return proFoodPrice;
	}
	public void setProFoodPrice(int proFoodPrice) {
		this.proFoodPrice = proFoodPrice;
	}
	public int getProFoodCarbo() {
		return proFoodCarbo;
	}
	public void setProFoodCarbo(int proFoodCarbo) {
		this.proFoodCarbo = proFoodCarbo;
	}
	public int getProFoodProt() {
		return proFoodProt;
	}
	public void setProFoodProt(int proFoodProt) {
		this.proFoodProt = proFoodProt;
	}
	public int getProFoodFat() {
		return proFoodFat;
	}
	public void setProFoodFat(int proFoodFat) {
		this.proFoodFat = proFoodFat;
	}
	public String getProFoodImage() {
		return proFoodImage;
	}
	public void setProFoodImage(String proFoodImage) {
		this.proFoodImage = proFoodImage;
	}
	public int getProFoodCal() {
		return proFoodCal;
	}
	public void setProFoodCal(int proFoodCal) {
		this.proFoodCal = proFoodCal;
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
	
}
