package command;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


@SuppressWarnings("serial")
public class ProReviewWriteCommand implements Serializable{

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String proReviewTitle;
	private String proReviewScore;
	private String proReviewComment;
	private MultipartFile proReviewImage;
	private Date proReviewRegdate;
	
	public int getProReviewNo() {
		return proReviewNo;
	}
	public void setProReviewNo(int proReviewNo) {
		this.proReviewNo = proReviewNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
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
	public String getProReviewTitle() {
		return proReviewTitle;
	}
	public void setProReviewTitle(String proReviewTitle) {
		this.proReviewTitle = proReviewTitle;
	}
	public String getProReviewScore() {
		return proReviewScore;
	}
	public void setProReviewScore(String proReviewScore) {
		this.proReviewScore = proReviewScore;
	}
	public String getProReviewComment() {
		return proReviewComment;
	}
	public void setProReviewComment(String proReviewComment) {
		this.proReviewComment = proReviewComment;
	}
	public MultipartFile getProReviewImage() {
		return proReviewImage;
	}
	public void setProReviewImage(MultipartFile proReviewImage) {
		this.proReviewImage = proReviewImage;
	}
	
	public Date getProReviewRegdate() {
		return proReviewRegdate;
	}
	public void setProReviewRegdate(Date proReviewRegdate) {
		this.proReviewRegdate = proReviewRegdate;
	}
	
	
	

	
	
	
	
}
