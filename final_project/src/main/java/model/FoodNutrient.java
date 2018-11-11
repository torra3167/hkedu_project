package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodNutrient implements Serializable {
	private String foodNutrientName;
	private int foodNutrientKcal;
	private int foodNutrientCarb;
	private int foodNutrientProt;
	private int foodNutrientFat;
	public FoodNutrient() {
	}
	public FoodNutrient(String foodNutrientName, int foodNutrientKcal, int foodNutrientCarb, int foodNutrientProt,
			int foodNutrientFat) {
		this.foodNutrientName = foodNutrientName;
		this.foodNutrientKcal = foodNutrientKcal;
		this.foodNutrientCarb = foodNutrientCarb;
		this.foodNutrientProt = foodNutrientProt;
		this.foodNutrientFat = foodNutrientFat;
	}
	public String getFoodNutrientName() {
		return foodNutrientName;
	}
	public void setFoodNutrientName(String foodNutrientName) {
		this.foodNutrientName = foodNutrientName;
	}
	public int getFoodNutrientKcal() {
		return foodNutrientKcal;
	}
	public void setFoodNutrientKcal(int foodNutrientKcal) {
		this.foodNutrientKcal = foodNutrientKcal;
	}
	public int getFoodNutrientCarb() {
		return foodNutrientCarb;
	}
	public void setFoodNutrientCarb(int foodNutrientCarb) {
		this.foodNutrientCarb = foodNutrientCarb;
	}
	public int getFoodNutrientProt() {
		return foodNutrientProt;
	}
	public void setFoodNutrientProt(int foodNutrientProt) {
		this.foodNutrientProt = foodNutrientProt;
	}
	public int getFoodNutrientFat() {
		return foodNutrientFat;
	}
	public void setFoodNutrientFat(int foodNutrientFat) {
		this.foodNutrientFat = foodNutrientFat;
	}
	
	
}
