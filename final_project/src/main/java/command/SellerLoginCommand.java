package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SellerLoginCommand implements Serializable{
	private String sellerEmail;
	private String sellerPw;
	private boolean rememberEmail;
	
	
	
	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}

	public SellerLoginCommand() {}

	public SellerLoginCommand(String sellerEmail, String sellerPw) {
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
