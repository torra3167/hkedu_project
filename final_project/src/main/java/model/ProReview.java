package model;

import java.io.Serializable;
import java.util.Date;



@SuppressWarnings("serial")
public class ProReview implements Serializable{

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String proReviewTitle;
	private String proReviewScore;
	private String proReviewComment;
	private Long proReviewSize;
	private String proReviewOriginal;
	private String proReviewStored;
	private Date proReviewRegdate;
	
	public ProReview() {}
	
	public ProReview(String memberEmail, int proNo, String coachEmail, String proReviewTitle, String proReviewScore,
			String proReviewComment, Long proReviewSize, String proReviewOriginal, String proReviewStored) {
		this.memberEmail = memberEmail;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proReviewTitle = proReviewTitle;
		this.proReviewScore = proReviewScore;
		this.proReviewComment = proReviewComment;
		this.proReviewSize = proReviewSize;
		this.proReviewOriginal = proReviewOriginal;
		this.proReviewStored = proReviewStored;
	}
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
	public Long getProReviewSize() {
		return proReviewSize;
	}
	public void setProReviewSize(Long proReviewSize) {
		this.proReviewSize = proReviewSize;
	}
	public String getProReviewOriginal() {
		return proReviewOriginal;
	}
	public void setProReviewOriginal(String proReviewOriginal) {
		this.proReviewOriginal = proReviewOriginal;
	}
	public String getProReviewStored() {
		return proReviewStored;
	}
	public void setProReviewStored(String proReviewStored) {
		this.proReviewStored = proReviewStored;
	}
	
	
	public Date getProReviewRegdate() {
		return proReviewRegdate;
	}
	public void setProReviewRegdate(Date proReviewRegdate) {
		this.proReviewRegdate = proReviewRegdate;
	}
	
	
	
	
	
	
	
}
