package command;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProReviewReportWriteCommand implements Serializable {

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String proReviewReportTitle;
	private String proReviewReportContent;
	private String proReviewReportWriter;
	private Date proReviewReportRegdate;
	
	
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
	public int getExerciseNumber() {
		return exerciseNumber;
	}
	public void setExerciseNumber(int exerciseNumber) {
		this.exerciseNumber = exerciseNumber;
	}
	public int getExerciseCatANumber() {
		return exerciseCatANumber;
	}
	public void setExerciseCatANumber(int exerciseCatANumber) {
		this.exerciseCatANumber = exerciseCatANumber;
	}
	public int getExerciseCatBNumber() {
		return exerciseCatBNumber;
	}
	public void setExerciseCatBNumber(int exerciseCatBNumber) {
		this.exerciseCatBNumber = exerciseCatBNumber;
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
	public String getProReviewReportWriter() {
		return proReviewReportWriter;
	}
	public void setProReviewReportWriter(String proReviewReportWriter) {
		this.proReviewReportWriter = proReviewReportWriter;
	}
	public Date getProReviewReportRegdate() {
		return proReviewReportRegdate;
	}
	public void setProReviewReportRegdate(Date proReviewReportRegdate) {
		this.proReviewReportRegdate = proReviewReportRegdate;
	}

	
	
}
