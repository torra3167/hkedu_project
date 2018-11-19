package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FoodReviewReport implements Serializable {
	private int foodReviewNo;
	private String memberEmail;
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodReportTitle;
	private int foodReportContent;
	private String foodReportWriter;
	private Date foodReportRegdate;
	public FoodReviewReport() {
	}
	public FoodReviewReport(int foodReviewNo, String memberEmail, int foodNo, String sellerEmail, int foodCatANo,
			int foodCatBNo, int foodCatCNo, String foodReportTitle, int foodReportContent, String foodReportWriter,
			Date foodReportRegdate) {
		this.foodReviewNo = foodReviewNo;
		this.memberEmail = memberEmail;
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodReportTitle = foodReportTitle;
		this.foodReportContent = foodReportContent;
		this.foodReportWriter = foodReportWriter;
		this.foodReportRegdate = foodReportRegdate;
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
	public String getFoodReportTitle() {
		return foodReportTitle;
	}
	public void setFoodReportTitle(String foodReportTitle) {
		this.foodReportTitle = foodReportTitle;
	}
	public int getFoodReportContent() {
		return foodReportContent;
	}
	public void setFoodReportContent(int foodReportContent) {
		this.foodReportContent = foodReportContent;
	}
	public String getFoodReportWriter() {
		return foodReportWriter;
	}
	public void setFoodReportWriter(String foodReportWriter) {
		this.foodReportWriter = foodReportWriter;
	}
	public Date getFoodReportRegdate() {
		return foodReportRegdate;
	}
	public void setFoodReportRegdate(Date foodReportRegdate) {
		this.foodReportRegdate = foodReportRegdate;
	}
	
	
}
