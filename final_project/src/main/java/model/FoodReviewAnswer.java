package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FoodReviewAnswer implements Serializable{
	private int reviewFNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodReviewAnswerNo;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodReviewAnswerContent;
	private Date foodReviewAnswerRegdate;
	public FoodReviewAnswer() {
	}
	public FoodReviewAnswer(int reviewFNo, String memberEmail, int foodNo, String sellerEmail, int foodReviewAnswerNo,
			int foodCatANo, int foodCatBNo, int foodCatCNo, String foodReviewAnswerContent,
			Date foodReviewAnswerRegdate) {
		this.reviewFNo = reviewFNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodReviewAnswerNo = foodReviewAnswerNo;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodReviewAnswerContent = foodReviewAnswerContent;
		this.foodReviewAnswerRegdate = foodReviewAnswerRegdate;
	}
	public int getReviewFNo() {
		return reviewFNo;
	}
	public void setReviewFNo(int reviewFNo) {
		this.reviewFNo = reviewFNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
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
	public int getFoodReviewAnswerNo() {
		return foodReviewAnswerNo;
	}
	public void setFoodReviewAnswerNo(int foodReviewAnswerNo) {
		this.foodReviewAnswerNo = foodReviewAnswerNo;
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
	public String getFoodReviewAnswerContent() {
		return foodReviewAnswerContent;
	}
	public void setFoodReviewAnswerContent(String foodReviewAnswerContent) {
		this.foodReviewAnswerContent = foodReviewAnswerContent;
	}
	public Date getFoodReviewAnswerRegdate() {
		return foodReviewAnswerRegdate;
	}
	public void setFoodReviewAnswerRegdate(Date foodReviewAnswerRegdate) {
		this.foodReviewAnswerRegdate = foodReviewAnswerRegdate;
	}
	
	
}
