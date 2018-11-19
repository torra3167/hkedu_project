package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SellerJoinCommand implements Serializable{
	private String sellerEmail;
	private String sellerPw;
	private String sellerConfirmPw;
	private String sellerPhone;
	private String sellerTerm;
	
	public SellerJoinCommand() {}

	public SellerJoinCommand(String sellerEmail, String sellerPw, String sellerConfirmPw, String sellerPhone,
			String sellerTerm) {
		this.sellerEmail = sellerEmail;
		this.sellerPw = sellerPw;
		this.sellerConfirmPw = sellerConfirmPw;
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
	public String getSellerConfirmPw() {
		return sellerConfirmPw;
	}
	public void setSellerConfirmPw(String sellerConfirmPw) {
		this.sellerConfirmPw = sellerConfirmPw;
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
}
