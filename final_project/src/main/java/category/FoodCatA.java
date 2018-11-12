package category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodCatA implements Serializable{
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodCatAName;
	
	public FoodCatA() {
	}
	public FoodCatA(int foodCatANo, int foodCatBNo, int foodCatCNo, String foodCatAName) {
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodCatAName = foodCatAName;
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
	public String getFoodCatAName() {
		return foodCatAName;
	}
	public void setFoodCatAName(String foodCatAName) {
		this.foodCatAName = foodCatAName;
	}
	
	
}
