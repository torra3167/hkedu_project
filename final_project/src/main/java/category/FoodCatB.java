package category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodCatB implements Serializable{
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodCatBName;
	public FoodCatB() {
	}
	public FoodCatB(int foodCatBNo, int foodCatCNo, String foodCatBName) {
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodCatBName = foodCatBName;
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
	public String getFoodCatBName() {
		return foodCatBName;
	}
	public void setFoodCatBName(String foodCatBName) {
		this.foodCatBName = foodCatBName;
	}
	
	
}
