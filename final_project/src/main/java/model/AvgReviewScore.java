package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AvgReviewScore implements Serializable{
	private int foodNo;
	private int avgReviewScore;
	
	public AvgReviewScore() {
	}

	public AvgReviewScore(int foodNo, int avgReviewScore) {
		this.foodNo = foodNo;
		this.avgReviewScore = avgReviewScore;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public int getAvgReviewScore() {
		return avgReviewScore;
	}

	public void setAvgReviewScore(int avgReviewScore) {
		this.avgReviewScore = avgReviewScore;
	}
	
	
}
