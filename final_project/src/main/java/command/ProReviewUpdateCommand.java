package command;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class ProReviewUpdateCommand implements Serializable{

	private int proReviewNo;
	private String proReviewTitle;
	private String proReviewScore;
	private String proReviewComment;
	private MultipartFile proReviewImage;
	private String proReviewOriginal;
	private String proReviewStored;
	private Date proReviewRegdate;
	
	
	public int getProReviewNo() {
		return proReviewNo;
	}
	public void setProReviewNo(int proReviewNo) {
		this.proReviewNo = proReviewNo;
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
