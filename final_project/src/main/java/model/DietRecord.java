package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DietRecord implements Serializable{
	private int dietRecordNo;
	private String memberEmail;
	private String foodNutrientname;
	private String dietRecordRegdate;
	private String dietRecordTime;
	private int foodQuantity;
	
	public DietRecord() {
	}

	public DietRecord(int dietRecordNo, String memberEmail, String foodNutrientname, String dietRecordRegdate,
			String dietRecordTime, int foodQuantity) {
		super();
		this.dietRecordNo = dietRecordNo;
		this.memberEmail = memberEmail;
		this.foodNutrientname = foodNutrientname;
		this.dietRecordRegdate = dietRecordRegdate;
		this.dietRecordTime = dietRecordTime;
		this.foodQuantity = foodQuantity;
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

	public String getFoodNutrientname() {
		return foodNutrientname;
	}

	public void setFoodNutrientname(String foodNutrientname) {
		this.foodNutrientname = foodNutrientname;
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




}
