package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExerciseUpdateCommand implements Serializable {

	private int exerciseNumber;
	private String exerciseContent;
	private int exerciseCal;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	
	public int getExerciseNumber() {
		return exerciseNumber;
	}
	public void setExerciseNumber(int exerciseNumber) {
		this.exerciseNumber = exerciseNumber;
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
