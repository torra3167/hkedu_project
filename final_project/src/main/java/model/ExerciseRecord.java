package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExerciseRecord implements Serializable {
	

	private int exerciseRecordNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseRecordName;
	private int exerciseRecordKg;
	private int exerciseRecordTimes;
	private int exerciseRecordWeight;
	private String exerciseRecordRegdate;
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
	public String getExerciseRecordName() {
		return exerciseRecordName;
	}
	public void setExerciseRecordName(String exerciseRecordName) {
		this.exerciseRecordName = exerciseRecordName;
	}
	public int getExerciseRecordKg() {
		return exerciseRecordKg;
	}
	public void setExerciseRecordKg(int exerciseRecordKg) {
		this.exerciseRecordKg = exerciseRecordKg;
	}
	public int getExerciseRecordTimes() {
		return exerciseRecordTimes;
	}
	public void setExerciseRecordTimes(int exerciseRecordTimes) {
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
	
	
	
}
