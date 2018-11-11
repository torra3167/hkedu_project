package command;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class ProReviewCommand implements Serializable{

	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;	
	private Date proReviewRegdate;
	private String proReviewName;
	private Date proReviewOrderDate;
	private String proReviewScore;
	private String proReviewComment;
	
	
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
	public Date getProReviewRegdate() {
		return proReviewRegdate;
	}
	public void setProReviewRegdate(Date proReviewRegdate) {
		this.proReviewRegdate = proReviewRegdate;
	}
	public String getProReviewName() {
		return proReviewName;
	}
	public void setProReviewName(String proReviewName) {
		this.proReviewName = proReviewName;
	}
	public Date getProReviewOrderDate() {
		return proReviewOrderDate;
	}
	public void setProReviewOrderDate(Date proReviewOrderDate) {
		this.proReviewOrderDate = proReviewOrderDate;
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
	
	
}
