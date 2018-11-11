package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProReviewAnswerCommand implements Serializable{

	private int proReviewAnswerNo;
	private int proReviewNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private int proReviewAnswerRegdate;
	private String proReviewAnswerContent;
	
	public int getProReviewAnswerNo() {
		return proReviewAnswerNo;
	}
	public void setProReviewAnswerNo(int proReviewAnswerNo) {
		this.proReviewAnswerNo = proReviewAnswerNo;
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
	public int getProReviewAnswerRegdate() {
		return proReviewAnswerRegdate;
	}
	public void setProReviewAnswerRegdate(int proReviewAnswerRegdate) {
		this.proReviewAnswerRegdate = proReviewAnswerRegdate;
	}
	public String getProReviewAnswerContent() {
		return proReviewAnswerContent;
	}
	public void setProReviewAnswerContent(String proReviewAnswerContent) {
		this.proReviewAnswerContent = proReviewAnswerContent;
	}
	
	
	
}	
