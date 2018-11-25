package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartOrderCommand implements Serializable{
	private String[] foodNo;
	private String[] proFoodNo;
	
	
	public String[] getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(String[] foodNo) {
		this.foodNo = foodNo;
	}
	public String[] getProFoodNo() {
		return proFoodNo;
	}
	public void setProFoodNo(String[] proFoodNo) {
		this.proFoodNo = proFoodNo;
	}
	
}
