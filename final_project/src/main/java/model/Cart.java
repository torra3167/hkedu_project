package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	//식품
	private int foodNo;
	private String sellerEmail;
	private int foodCatANo;
	private int foodCatBNo;
	private int foodCatCNo;
	private String foodName;
	private int foodPrice;
	private String foodImage;
	//전체상품갯수
	private int demandQty;
	
	//프로그램
	
	private int proNo;
	private String coachEmail;
	private String proName;
	private String proStored;
	private String proContent;
	private int proPrice;
	
	public Cart() {
	}
	
	
	
	
	public Cart(int proNo, String coachEmail, String proName, String proStored, String proContent, int proPrice) {
		super();
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proName = proName;
		this.proStored = proStored;
		this.proContent = proContent;
		this.proPrice = proPrice;
	}




	public Cart(int foodNo, String sellerEmail, int foodCatANo, int foodCatBNo, int foodCatCNo, String foodName,
			int foodPrice, String foodImage, int demandQty) {
		super();
		this.foodNo = foodNo;
		this.sellerEmail = sellerEmail;
		this.foodCatANo = foodCatANo;
		this.foodCatBNo = foodCatBNo;
		this.foodCatCNo = foodCatCNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.demandQty = demandQty;
	}


	public Cart(int foodNo, String foodName, int foodPrice, String foodImage, int demandQty) {
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
		this.demandQty = demandQty;
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


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public String getProStored() {
		return proStored;
	}


	public void setProStored(String proStored) {
		this.proStored = proStored;
	}


	public String getProContent() {
		return proContent;
	}


	public void setProContent(String proContent) {
		this.proContent = proContent;
	}


	public int getProPrice() {
		return proPrice;
	}


	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
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

	public int getDemandQty() {
		return demandQty;
	}
	public void setDemandQty(int demandQty) {
		this.demandQty = demandQty;
	}
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	
}
