package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ReviewFood implements Serializable {
	private int reviewFNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private Date reviewFoodRegdate;
	private String reviewFoodName;
	private Date reviewFoodOrderdate;
	private int reviewFoodScore;
	private String reviewFoodComment;
	private String reviewFoodImage;
	
	public ReviewFood() {
	}

	public ReviewFood(int reviewFNo, String memberEmail, int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo,
			int foodCatCNo, Date reviewFoodRegdate, String reviewFoodName, Date reviewFoodOrderdate,
			int reviewFoodScore, String reviewFoodComment, String reviewFoodImage) {
		this.reviewFNo = reviewFNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.reviewFoodRegdate = reviewFoodRegdate;
		this.reviewFoodName = reviewFoodName;
		this.reviewFoodOrderdate = reviewFoodOrderdate;
		this.reviewFoodScore = reviewFoodScore;
		this.reviewFoodComment = reviewFoodComment;
		this.reviewFoodImage = reviewFoodImage;
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

	public Date getReviewFoodRegdate() {
		return reviewFoodRegdate;
	}

	public void setReviewFoodRegdate(Date reviewFoodRegdate) {
		this.reviewFoodRegdate = reviewFoodRegdate;
	}

	public String getReviewFoodName() {
		return reviewFoodName;
	}

	public void setReviewFoodName(String reviewFoodName) {
		this.reviewFoodName = reviewFoodName;
	}

	public Date getReviewFoodOrderdate() {
		return reviewFoodOrderdate;
	}

	public void setReviewFoodOrderdate(Date reviewFoodOrderdate) {
		this.reviewFoodOrderdate = reviewFoodOrderdate;
	}

	public int getReviewFoodScore() {
		return reviewFoodScore;
	}

	public void setReviewFoodScore(int reviewFoodScore) {
		this.reviewFoodScore = reviewFoodScore;
	}

	public String getReviewFoodComment() {
		return reviewFoodComment;
	}

	public void setReviewFoodComment(String reviewFoodComment) {
		this.reviewFoodComment = reviewFoodComment;
	}

	public String getReviewFoodImage() {
		return reviewFoodImage;
	}

	public void setReviewFoodImage(String reviewFoodImage) {
		this.reviewFoodImage = reviewFoodImage;
	}
	
	
	
}

