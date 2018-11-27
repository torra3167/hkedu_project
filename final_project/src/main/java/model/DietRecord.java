package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DietRecord implements Serializable{
	private String dietRecordRegdate;
	private String dietRecordTime;
	private String memberEmail;
	private String foodNutrientname;
	private int foodQuantity;
	
	public DietRecord() {
	}

	public DietRecord(String dietRecordRegdate, String dietRecordTime, String memberEmail, String foodNutrientname,
			int foodQuantity) {
		this.dietRecordRegdate = dietRecordRegdate;
		this.dietRecordTime = dietRecordTime;
		this.memberEmail = memberEmail;
		this.foodNutrientname = foodNutrientname;
		this.foodQuantity = foodQuantity;
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

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}


}
