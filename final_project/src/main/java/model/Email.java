package model;

public class Email {
	private String email;
	private String name;
	private String phone;
	private String divide;

	public Email() {
		super();
	}

	public Email(String email, String divide) {
		super();
		this.email = email;
		this.divide = divide;
	}

	public Email(String email, String name, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDivide() {
		return divide;
	}

	public void setDivide(String divide) {
		this.divide = divide;
	}
}
