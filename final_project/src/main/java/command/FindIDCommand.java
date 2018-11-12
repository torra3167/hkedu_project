package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FindIDCommand implements Serializable {
	private String memberEmail;
	private String memberPhone;
	private String memberName;

	public FindIDCommand() {
	}

	public FindIDCommand(String memberEmail, String memberPhone, String memberName) {
		super();
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
