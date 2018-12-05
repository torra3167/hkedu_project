package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DietRecordFood implements Serializable{
	private int dietRecordNo;
	private String memberEmail;
	private String foodNutrientName;
	private String dietRecordRegdate;
	private String dietRecordTime;
	private int foodQuantity;
	private int foodCarbo;
	private int foodProtein;
	private int foodFat;
	private int foodCal;
	
	public DietRecordFood() {
	}
	public DietRecordFood(int dietRecordNo, String memberEmail, String foodNutrientName, String dietRecordRegdate,
			String dietRecordTime, int foodQuantity, int foodCarbo, int foodProtein, int foodFat, int foodCal) {
		this.dietRecordNo = dietRecordNo;
		this.memberEmail = memberEmail;
		this.foodNutrientName = foodNutrientName;
		this.dietRecordRegdate = dietRecordRegdate;
		this.dietRecordTime = dietRecordTime;
		this.foodQuantity = foodQuantity;
		this.foodCarbo = foodCarbo;
		this.foodProtein = foodProtein;
		this.foodFat = foodFat;
		this.foodCal = foodCal;
	}
	public int getDietRecordNo() {
		return dietRecordNo;
	}
	public void setDietRecordNo(int dietRecordNo) {
		this.dietRecordNo = dietRecordNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getFoodNutrientName() {
		return foodNutrientName;
	}
	public void setFoodNutrientName(String foodNutrientName) {
		this.foodNutrientName = foodNutrientName;
	}
	public String getDietRecordRegdate() {
		return dietRecordRegdate;
	}
	public void setDietRecordRegdate(String dietRecordRegdate) {
		this.dietRecordRegdate = dietRecordRegdate;
	}
	public String getDietRecordTime() {
		return dietRecordTime;
	}
	public void setDietRecordTime(String dietRecordTime) {
		this.dietRecordTime = dietRecordTime;
	}
	public int getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
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
	
	
}
