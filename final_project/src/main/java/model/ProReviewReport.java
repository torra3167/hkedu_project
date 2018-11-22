package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProReviewReport implements Serializable {

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String proReviewReportTitle;
	private String proReviewReportContent;
	private String proReviewReportRegdate;
	
	public ProReviewReport () {}
	
	// 멤버이메일, 프로그램번호, 코치이메일, 타이틀, 콘텐트
	public ProReviewReport(String memberEmail, int proNo, String coachEmail,
			String proReviewReportTitle, String proReviewReportContent) {
		super();
		this.memberEmail = memberEmail;
		this.proNo = proNo;
		this.coachEmail = coachEmail;
		this.proReviewReportTitle = proReviewReportTitle;
		this.proReviewReportContent = proReviewReportContent;
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
