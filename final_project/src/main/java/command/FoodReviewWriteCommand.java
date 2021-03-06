package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class FoodReviewWriteCommand implements Serializable{
	private int foodReviewNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodReviewRegdate;
	private String foodReviewFoodName;
	private int foodReviewScore;
	private String foodReviewTitle;
	private String foodReviewComment;
	private MultipartFile foodReviewImage;
	public FoodReviewWriteCommand() {
	}
	public FoodReviewWriteCommand(int foodReviewNo, String memberEmail, int foodNo, String sellerEmail, int foodCatANo,
			int foodCatBNo, int foodCatCNo, String foodReviewRegdate, String foodReviewFoodName, int foodReviewScore,
			String foodReviewTitle, String foodReviewComment, MultipartFile foodReviewImage) {
	
		this.foodReviewNo = foodReviewNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodReviewRegdate = foodReviewRegdate;
		this.foodReviewFoodName = foodReviewFoodName;
		this.foodReviewScore = foodReviewScore;
		this.foodReviewTitle = foodReviewTitle;
		this.foodReviewComment = foodReviewComment;
		this.foodReviewImage = foodReviewImage;
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
	public int getFoodReviewScore() {
		return foodReviewScore;
	}
	public void setFoodReviewScore(int foodReviewScore) {
		this.foodReviewScore = foodReviewScore;
	}
	public String getFoodReviewTitle() {
		return foodReviewTitle;
	}
	public void setFoodReviewTitle(String foodReviewTitle) {
		this.foodReviewTitle = foodReviewTitle;
	}
	public String getFoodReviewComment() {
		return foodReviewComment;
	}
	public void setFoodReviewComment(String foodReviewComment) {
		this.foodReviewComment = foodReviewComment;
	}
	public MultipartFile getFoodReviewImage() {
		return foodReviewImage;
	}
	public void setFoodReviewImage(MultipartFile foodReviewImage) {
		this.foodReviewImage = foodReviewImage;
	}
	
	
	
}
