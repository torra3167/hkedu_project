package controller;

public class EmailCommand {
	private String memberEmail;
	private String memberName;
	
	public EmailCommand() { }
	
	public EmailCommand(String memberEmail, String memberName) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
