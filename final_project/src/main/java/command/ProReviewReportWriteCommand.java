package command;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProReviewReportWriteCommand implements Serializable {

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String proReviewReportTitle;
	private String proReviewReportContent;
	private String proReviewReportRegdate;
	
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
	public String getProReviewReportTitle() {
		return proReviewReportTitle;
	}
	public void setProReviewReportTitle(String proReviewReportTitle) {
		this.proReviewReportTitle = proReviewReportTitle;
	}
	public String getProReviewReportContent() {
		return proReviewReportContent;
	}
	public void setProReviewReportContent(String proReviewReportContent) {
		this.proReviewReportContent = proReviewReportContent;
	}
	
	public String getProReviewReportRegdate() {
		return proReviewReportRegdate;
	}
	public void setProReviewReportRegdate(String proReviewReportRegdate) {
		this.proReviewReportRegdate = proReviewReportRegdate;
	}
	
	
	
	
	
}
