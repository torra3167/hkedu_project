package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramExerciseExercise implements Serializable {
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseCatAName;
	private String exerciseContent;
	private int exerciseCal;
	
	
	
	public String getExerciseCatAName() {
		return exerciseCatAName;
	}
	public void setExerciseCatAName(String exerciseCatAName) {
		this.exerciseCatAName = exerciseCatAName;
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
	public String getExerciseContent() {
		return exerciseContent;
	}
	public void setExerciseContent(String exerciseContent) {
		this.exerciseContent = exerciseContent;
	}
	public int getExerciseCal() {
		return exerciseCal;
	}
	public void setExerciseCal(int exerciseCal) {
		this.exerciseCal = exerciseCal;
	}
	
	
	
	
	
	
}
