package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FindIDCommand implements Serializable {
	private String email;
	private String phone;
	private String name;
	
	public FindIDCommand() {
		super();
	}

	public FindIDCommand(String email, String phone, String name) {
		super();
		this.email = email;
		this.phone = phone;
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
