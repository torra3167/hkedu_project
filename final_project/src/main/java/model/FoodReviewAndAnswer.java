package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FoodReviewAndAnswer implements Serializable{
	private int foodReviewNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private Date foodReviewRegdate;
	private String foodReviewFoodName;
	private String foodReviewOrderdate;
	private String foodReviewTitle;
	private String foodReviewScore;
	private String foodReviewComment;
	private Long foodReviewSize;
	private String foodReviewOriginal;
	private String foodReviewStored;
	private int foodReviewAnswerNo;
	private String foodReviewAnswerContent;
	private Date foodReviewAnswerRegdate;
	public FoodReviewAndAnswer() {
	}
	public FoodReviewAndAnswer(int foodReviewNo, String memberEmail, int foodNo, String sellerEmail, int foodCatANo,
			int foodCatBNo, int foodCatCNo, Date foodReviewRegdate, String foodReviewFoodName,
			String foodReviewOrderdate, String foodReviewTitle, String foodReviewScore, String foodReviewComment,
			Long foodReviewSize, String foodReviewOriginal, String foodReviewStored, int foodReviewAnswerNo,
			String foodReviewAnswerContent, Date foodReviewAnswerRegdate) {
		this.foodReviewNo = foodReviewNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodReviewRegdate = foodReviewRegdate;
		this.foodReviewFoodName = foodReviewFoodName;
		this.foodReviewOrderdate = foodReviewOrderdate;
		this.foodReviewTitle = foodReviewTitle;
		this.foodReviewScore = foodReviewScore;
		this.foodReviewComment = foodReviewComment;
		this.foodReviewSize = foodReviewSize;
		this.foodReviewOriginal = foodReviewOriginal;
		this.foodReviewStored = foodReviewStored;
		this.foodReviewAnswerNo = foodReviewAnswerNo;
		this.foodReviewAnswerContent = foodReviewAnswerContent;
		this.foodReviewAnswerRegdate = foodReviewAnswerRegdate;
	}
	public int getFoodReviewNo() {
		return foodReviewNo;
	}
	public void setFoodReviewNo(int foodReviewNo) {
		this.foodReviewNo = foodReviewNo;
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
	public Date getFoodReviewRegdate() {
		return foodReviewRegdate;
	}
	public void setFoodReviewRegdate(Date foodReviewRegdate) {
		this.foodReviewRegdate = foodReviewRegdate;
	}
	public String getFoodReviewFoodName() {
		return foodReviewFoodName;
	}
	public void setFoodReviewFoodName(String foodReviewFoodName) {
		this.foodReviewFoodName = foodReviewFoodName;
	}
	public String getFoodReviewOrderdate() {
		return foodReviewOrderdate;
	}
	public void setFoodReviewOrderdate(String foodReviewOrderdate) {
		this.foodReviewOrderdate = foodReviewOrderdate;
	}
	public String getFoodReviewTitle() {
		return foodReviewTitle;
	}
	public void setFoodReviewTitle(String foodReviewTitle) {
		this.foodReviewTitle = foodReviewTitle;
	}
	public String getFoodReviewScore() {
		return foodReviewScore;
	}
	public void setFoodReviewScore(String foodReviewScore) {
		this.foodReviewScore = foodReviewScore;
	}
	public String getFoodReviewComment() {
		return foodReviewComment;
	}
	public void setFoodReviewComment(String foodReviewComment) {
		this.foodReviewComment = foodReviewComment;
	}
	public Long getFoodReviewSize() {
		return foodReviewSize;
	}
	public void setFoodReviewSize(Long foodReviewSize) {
		this.foodReviewSize = foodReviewSize;
	}
	public String getFoodReviewOriginal() {
		return foodReviewOriginal;
	}
	public void setFoodReviewOriginal(String foodReviewOriginal) {
		this.foodReviewOriginal = foodReviewOriginal;
	}
	public String getFoodReviewStored() {
		return foodReviewStored;
	}
	public void setFoodReviewStored(String foodReviewStored) {
		this.foodReviewStored = foodReviewStored;
	}
	public int getFoodReviewAnswerNo() {
		return foodReviewAnswerNo;
	}
	public void setFoodReviewAnswerNo(int foodReviewAnswerNo) {
		this.foodReviewAnswerNo = foodReviewAnswerNo;
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
