package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Program implements Serializable {
	
	private int proNo;
	private String coachEmail;
	private String proName;
	private Long proSize;
	private String proOriginal;
	private String proStored;
	private String proRegdate;
	private String proContent;
	private String proStatus;
	private String proDes;
	private int proPrice;
	
	

	public int getProPrice() {
		return proPrice;
	}



	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}



	public Program() {}
	//프로그램번호, 코치이메일, 프로그램이름, 사이즈, 오리지널, 저장된

	
	
	
	public Program(int proNo, String coachEmail, String proName, Long proSize, String proOriginal, String proStored, String proContent) {
		
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proName = proName;
		this.proSize = proSize;
		this.proOriginal = proOriginal;
		this.proStored = proStored;
		this.proContent = proContent;
	}

	
	

	public Program(int proNo, String coachEmail, String proName, Long proSize, String proOriginal, String proStored,
			String proContent, int proPrice) {
		super();
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proName = proName;
		this.proSize = proSize;
		this.proOriginal = proOriginal;
		this.proStored = proStored;
		this.proContent = proContent;
		this.proPrice = proPrice;
	}



	public String getProRegdate() {
		return proRegdate;
	}



	public void setProRegdate(String proRegdate) {
		this.proRegdate = proRegdate;
	}



	public String getProContent() {
		return proContent;
	}


	public void setProContent(String proContent) {
		this.proContent = proContent;
	}



	public int getProNo() {
		return proNo;
	}


	public void setProNo(int proNo) {
		this.proNo = proNo;
	}


	public String getCoachEmail() {
		return coachEmail;
	}


	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public Long getProSize() {
		return proSize;
	}


	public void setProSize(Long proSize) {
		this.proSize = proSize;
	}


	public String getProOriginal() {
		return proOriginal;
	}


	public void setProOriginal(String proOriginal) {
		this.proOriginal = proOriginal;
	}


	public String getProStored() {
		return proStored;
	}


	public void setProStored(String proStored) {
		this.proStored = proStored;
	}


	


	public String getProStatus() {
		return proStatus;
	}


	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}


	public String getProDes() {
		return proDes;
	}


	public void setProDes(String proDes) {
		this.proDes = proDes;
	}
	
	

	
	
	
}
