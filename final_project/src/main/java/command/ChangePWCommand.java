package command;

public class ChangePWCommand {
	private String email;
	private String newPW;
	private String newPWchk;
	
	public ChangePWCommand() {
		super();
	}

	public ChangePWCommand(String email, String newPW, String newPWchk) {
		super();
		this.email = email;
		this.newPW = newPW;
		this.newPWchk = newPWchk;
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
	public String getNewPWchk() {
		return newPWchk;
	}
	public void setNewPWchk(String newPWchk) {
		this.newPWchk = newPWchk;
	}
}
