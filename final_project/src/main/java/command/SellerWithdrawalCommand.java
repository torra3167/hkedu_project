package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SellerWithdrawalCommand implements Serializable{
	private String sellerEmail;
	private String sellerPw;
	
	public SellerWithdrawalCommand() {
	}
	public SellerWithdrawalCommand(String sellerEmail, String sellerPw) {
		this.sellerEmail = sellerEmail;
		this.sellerPw = sellerPw;
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
	
	
}
