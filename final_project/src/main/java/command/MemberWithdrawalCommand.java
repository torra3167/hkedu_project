package command;

public class MemberWithdrawalCommand {
	private String memberEmail;
	private String memberPass;
	
	public MemberWithdrawalCommand() {	}
	
	public MemberWithdrawalCommand(String memberEmail, String memberPass) {
		super();
		this.memberEmail = memberEmail;
		this.memberPass = memberPass;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
}
