package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class FoodReviewAndAnswer implements Serializable{
	private int foodReviewNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodReviewRegdate;
	private String foodReviewFoodName;
	private String foodReviewTitle;
	private int foodReviewScore;
	private String foodReviewComment;
	private Long foodReviewSize;
	private String foodReviewOriginal;
	private String foodReviewStored;
	private List<FoodReviewAnswer> foodReviewAnswers;
	public FoodReviewAndAnswer() {
	}
	public FoodReviewAndAnswer(int foodReviewNo, String memberEmail, int foodNo, String sellerEmail, int foodCatANo,
			int foodCatBNo, int foodCatCNo, String foodReviewRegdate, String foodReviewFoodName, String foodReviewTitle,
			int foodReviewScore, String foodReviewComment, Long foodReviewSize, String foodReviewOriginal,
			String foodReviewStored, List<FoodReviewAnswer> foodReviewAnswers) {
		this.foodReviewNo = foodReviewNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodReviewRegdate = foodReviewRegdate;
		this.foodReviewFoodName = foodReviewFoodName;
		this.foodReviewTitle = foodReviewTitle;
		this.foodReviewScore = foodReviewScore;
		this.foodReviewComment = foodReviewComment;
		this.foodReviewSize = foodReviewSize;
		this.foodReviewOriginal = foodReviewOriginal;
		this.foodReviewStored = foodReviewStored;
		this.foodReviewAnswers = foodReviewAnswers;
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
	public String getFoodReviewRegdate() {
		return foodReviewRegdate;
	}
	public void setFoodReviewRegdate(String foodReviewRegdate) {
		this.foodReviewRegdate = foodReviewRegdate;
	}
	public String getFoodReviewFoodName() {
		return foodReviewFoodName;
	}
	public void setFoodReviewFoodName(String foodReviewFoodName) {
		this.foodReviewFoodName = foodReviewFoodName;
	}
	public String getFoodReviewTitle() {
		return foodReviewTitle;
	}
	public void setFoodReviewTitle(String foodReviewTitle) {
		this.foodReviewTitle = foodReviewTitle;
	}
	public int getFoodReviewScore() {
		return foodReviewScore;
	}
	public void setFoodReviewScore(int foodReviewScore) {
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
	public List<FoodReviewAnswer> getFoodReviewAnswers() {
		return foodReviewAnswers;
	}
	public void setFoodReviewAnswers(List<FoodReviewAnswer> foodReviewAnswers) {
		this.foodReviewAnswers = foodReviewAnswers;
	}
	
	
	
}
