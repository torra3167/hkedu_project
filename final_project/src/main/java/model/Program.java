package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Program implements Serializable {
	
	private int proNo;
	private String coachEmail;
	private String proName;
	private Long programSize;
	private String programOriginal;
	private String programStored;
	private Date proRegdate;
	private String proStatus;
	private String proDes;
	
	
	public Program() {}
	
	public Program(int proNo, String coachEmail, String proName, Long programSize, String programOriginal,
			String programStored) {
		
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proName = proName;
		this.programSize = programSize;
		this.programOriginal = programOriginal;
		this.programStored = programStored;
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
	
	public Date getProRegdate() {
		return proRegdate;
	}
	public void setProRegdate(Date proRegdate) {
		this.proRegdate = proRegdate;
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


	public Long getProgramSize() {
		return programSize;
	}


	public void setProgramSize(Long programSize) {
		this.programSize = programSize;
	}


	public String getProgramOriginal() {
		return programOriginal;
	}


	public void setProgramOriginal(String programOriginal) {
		this.programOriginal = programOriginal;
	}


	public String getProgramStored() {
		return programStored;
	}


	public void setProgramStored(String programStored) {
		this.programStored = programStored;
	}
	
	
	
	
}
