package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProFood implements Serializable{
	private int proFoodNo;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private int proNo;
	private String coachEmail;
	
	public ProFood() {
		super();
	}
	public ProFood(int proFoodNo, int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo,
			int proNo, String coachEmail) {
		super();
		this.proFoodNo = proFoodNo;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
	}





	public int getProFoodNo() {
		return proFoodNo;
	}

	public void setProFoodNo(int proFoodNo) {
		this.proFoodNo = proFoodNo;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
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

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	
	
}
