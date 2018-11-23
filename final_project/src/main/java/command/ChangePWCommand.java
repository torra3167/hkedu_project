package command;

public class ChangePWCommand {
	private String email;
	private String newPW;
	private String nowPW;
	
	public ChangePWCommand() {
		super();
	}

	public ChangePWCommand(String email, String newPW) {
		super();
		this.email = email;
		this.newPW = newPW;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewPW() {
		return newPW;
	}
	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	public String getNowPW() {
		return nowPW;
	}
	public void setNowPW(String nowPW) {
		this.nowPW = nowPW;
	}
}
