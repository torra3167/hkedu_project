package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Seller implements Serializable{
	private String sellerEmail;
	private String sellerPw;
	private String sellerPhone;
	private String sellerTerm;
	private String sellerDivide;
	
	public Seller() {}


	public Seller(String sellerEmail, String sellerPw, String sellerPhone, String sellerTerm, String sellerDivide) {
		this.sellerEmail = sellerEmail;
		this.sellerPw = sellerPw;
		this.sellerPhone = sellerPhone;
		this.sellerTerm = sellerTerm;
		this.sellerDivide = sellerDivide;
	}
	
	
	
	public String getSellerEmail() {
		return sellerEmail;
	}


	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}


	public String getSellerPw() {
		return sellerPw;
	}


	public void setSellerPw(String sellerPw) {
		this.sellerPw = sellerPw;
	}


	public String getSellerPhone() {
		return sellerPhone;
	}


	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}


	public String getSellerTerm() {
		return sellerTerm;
	}


	public void setSellerTerm(String sellerTerm) {
		this.sellerTerm = sellerTerm;
	}


	public String getSellerDivide() {
		return sellerDivide;
	}


	public void setSellerDivide(String sellerDivide) {
		this.sellerDivide = sellerDivide;
	}
}
