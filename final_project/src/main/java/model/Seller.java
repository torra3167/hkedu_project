package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Seller implements Serializable{
	private String sellerEmail;
	private String sellerPw;
	private int sellerPhone;
	private String sellerTerm;
	
	public Seller() {}
	
	public Seller(String sellerEmail, String sellerPw, int sellerPhone, String sellerTerm) {
		this.sellerEmail = sellerEmail;
		this.sellerPw = sellerPw;
		this.sellerPhone = sellerPhone;
		this.sellerTerm = sellerTerm;
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

	public int getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(int sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerTerm() {
		return sellerTerm;
	}

	public void setSellerTerm(String sellerTerm) {
		this.sellerTerm = sellerTerm;
	}
}