package category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodCatC implements Serializable{
	private int foodCatCNo;
	private String foodCatCName;
	public FoodCatC() {
	}
	public FoodCatC(int foodCatCNo, String foodCatCName) {
		this.foodCatCNo = foodCatCNo;
		this.foodCatCName = foodCatCName;
	}
	public int getFoodCatCNo() {
		return foodCatCNo;
	}
	public void setFoodCatCNo(int foodCatCNo) {
		this.foodCatCNo = foodCatCNo;
	}
	public String getFoodCatCName() {
		return foodCatCName;
	}
	public void setFoodCatCName(String foodCatCName) {
		this.foodCatCName = foodCatCName;
	}
	
	
}
