package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExerciseRecCommand implements Serializable {
	

	private int exerciseRecordNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private String[] exerciseRecordName;
	private String[] exerciseRecordKg;
	private String[] exerciseRecordTimes;
	private int exerciseRecordWeight;
	private String exerciseRecordRegdate;

	
	
	public ExerciseRecCommand() {
		super();
	}



	public int getExerciseRecordNo() {
		return exerciseRecordNo;
	}



	public void setExerciseRecordNo(int exerciseRecordNo) {
		this.exerciseRecordNo = exerciseRecordNo;
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



	public String getCoachEmail() {
		return coachEmail;
	}



	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}



	public String[] getExerciseRecordName() {
		return exerciseRecordName;
	}



	public void setExerciseRecordName(String[] exerciseRecordName) {
		this.exerciseRecordName = exerciseRecordName;
	}



	public String[] getExerciseRecordKg() {
		return exerciseRecordKg;
	}



	public void setExerciseRecordKg(String[] exerciseRecordKg) {
		this.exerciseRecordKg = exerciseRecordKg;
	}



	public String[] getExerciseRecordTimes() {
		return exerciseRecordTimes;
	}



	public void setExerciseRecordTimes(String[] exerciseRecordTimes) {
		this.exerciseRecordTimes = exerciseRecordTimes;
	}



	public int getExerciseRecordWeight() {
		return exerciseRecordWeight;
	}



	public void setExerciseRecordWeight(int exerciseRecordWeight) {
		this.exerciseRecordWeight = exerciseRecordWeight;
	}



	public String getExerciseRecordRegdate() {
		return exerciseRecordRegdate;
	}



	public void setExerciseRecordRegdate(String exerciseRecordRegdate) {
		this.exerciseRecordRegdate = exerciseRecordRegdate;
	}



	public void setProNo(int proNo) {
		this.proNo = proNo;
	}



	
	
	
	
	
}
