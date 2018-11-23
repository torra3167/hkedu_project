package category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExerciseCatA implements Serializable {	
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseCatAName;
	
	public ExerciseCatA() {}
	
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
	public String getExerciseCatAName() {
		return exerciseCatAName;
	}
	public void setExerciseCatAName(String exerciseCatAName) {
		this.exerciseCatAName = exerciseCatAName;
	}
	
	
	
	
	
	
	
}
