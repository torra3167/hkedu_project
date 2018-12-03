package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodNutrient implements Serializable {
	private String foodNutrientName;
	private String foodNutrientCatName;
	private int foodNutrientCal;
	private int foodNutrientCarbo;
	private int foodNutrientProtein;
	private int foodNutrientFat;
	
	public FoodNutrient() {
	}

	public FoodNutrient(String foodNutrientName, String foodNutrientCatName, int foodNutrientCal, int foodNutrientCarbo,
			int foodNutrientProtein, int foodNutrientFat) {
		super();
		this.foodNutrientName = foodNutrientName;
		this.foodNutrientCatName = foodNutrientCatName;
		this.foodNutrientCal = foodNutrientCal;
		this.foodNutrientCarbo = foodNutrientCarbo;
		this.foodNutrientProtein = foodNutrientProtein;
		this.foodNutrientFat = foodNutrientFat;
	}

	public String getFoodNutrientName() {
		return foodNutrientName;
	}

	public void setFoodNutrientName(String foodNutrientName) {
		this.foodNutrientName = foodNutrientName;
	}

	public String getFoodNutrientCatName() {
		return foodNutrientCatName;
	}

	public void setFoodNutrientCatName(String foodNutrientCatName) {
		this.foodNutrientCatName = foodNutrientCatName;
	}

	public int getFoodNutrientCal() {
		return foodNutrientCal;
	}

	public void setFoodNutrientCal(int foodNutrientCal) {
		this.foodNutrientCal = foodNutrientCal;
	}

	public int getFoodNutrientCarbo() {
		return foodNutrientCarbo;
	}

	public void setFoodNutrientCarbo(int foodNutrientCarbo) {
		this.foodNutrientCarbo = foodNutrientCarbo;
	}

	public int getFoodNutrientProtein() {
		return foodNutrientProtein;
	}

	public void setFoodNutrientProtein(int foodNutrientProtein) {
		this.foodNutrientProtein = foodNutrientProtein;
	}

	public int getFoodNutrientFat() {
		return foodNutrientFat;
	}

	public void setFoodNutrientFat(int foodNutrientFat) {
		this.foodNutrientFat = foodNutrientFat;
	}



	
	
}
