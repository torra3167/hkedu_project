package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AvgReviewScore implements Serializable{
	private int foodNo;
	private double avgReviewScore;
	
	public AvgReviewScore() {
	}
	public AvgReviewScore(int foodNo, double avgReviewScore) {
		this.foodNo = foodNo;
		this.avgReviewScore = avgReviewScore;
	}
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public double getAvgReviewScore() {
		return avgReviewScore;
	}
	public void setAvgReviewScore(double avgReviewScore) {
		this.avgReviewScore = avgReviewScore;
	}
	
}
