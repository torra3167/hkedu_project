package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodOrderCommand implements Serializable {
	private String[] foodNo;
	private int foodOrderPrice;
	private int[] foodOrderQuant;
	private String foodOrderName;
	private String foodOrderStored;
	
	
	public String getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(String foodNo) {
		this.foodNo = foodNo;
	}
	public int getFoodOrderPrice() {
		return foodOrderPrice;
	}
	public void setFoodOrderPrice(int foodOrderPrice) {
		this.foodOrderPrice = foodOrderPrice;
	}
	public int getFoodOrderQuant() {
		return foodOrderQuant;
	}
	public void setFoodOrderQuant(int foodOrderQuant) {
		this.foodOrderQuant = foodOrderQuant;
	}
	public String getFoodOrderName() {
		return foodOrderName;
	}
	public void setFoodOrderName(String foodOrderName) {
		this.foodOrderName = foodOrderName;
	}
	public String getFoodOrderStored() {
		return foodOrderStored;
	}
	public void setFoodOrderStored(String foodOrderStored) {
		this.foodOrderStored = foodOrderStored;
	}
	
	
	
}
