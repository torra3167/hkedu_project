package command;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class ProgramCommand implements Serializable {

	private String proName;
	private MultipartFile proImg;
	private Date proRegdate;
	private String coachEmail;

	
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
	public MultipartFile getProImg() {
		return proImg;
	}
	public void setProImg(MultipartFile proImg) {
		this.proImg = proImg;
	}
	public Date getProRegdate() {
		return proRegdate;
	}
	public void setProRegdate(Date proRegdate) {
		this.proRegdate = proRegdate;
	}
	
	
}
