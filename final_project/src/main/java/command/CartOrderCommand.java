package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartOrderCommand implements Serializable{
	private String[] foodNo;
	private String[] proFoodNo;
	private String[] proNo;
	private int proOrderTotal;
	
	

	
	
	public int getProOrderTotal() {
		return proOrderTotal;
	}
	public void setProOrderTotal(int proOrderTotal) {
		this.proOrderTotal = proOrderTotal;
	}
	public String[] getProNo() {
		return proNo;
	}
	public void setProNo(String[] proNo) {
		this.proNo = proNo;
	}
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
