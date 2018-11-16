package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramExercise implements Serializable {
	
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	
	
	
	public ProgramExercise() {
	}
	
	public ProgramExercise(int pro_no, int exerciseNumber, int exerciseCatANumber,
			int exerciseCatBNumber) {
		this.proNo = pro_no;
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
	}
	
	public ProgramExercise(int pro_no, String coachEmail, int exerciseNumber, int exerciseCatANumber,
			int exerciseCatBNumber) {
		this.proNo = pro_no;
		this.coachEmail = coachEmail;
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
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
	
	
	
	

}
