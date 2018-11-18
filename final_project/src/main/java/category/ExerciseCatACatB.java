package category;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExerciseCatACatB implements Serializable {	
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseCatAName;
	private String exerciseCatBName;
	
	
	
	
	public ExerciseCatACatB(int exerciseCatANumber, int exerciseCatBNumber) {
		
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
	}

	public ExerciseCatACatB() {
		
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
	public String getExerciseCatAName() {
		return exerciseCatAName;
	}
	public void setExerciseCatAName(String exerciseCatAName) {
		this.exerciseCatAName = exerciseCatAName;
	}
	public String getExerciseCatBName() {
		return exerciseCatBName;
	}
	public void setExerciseCatBName(String exerciseCatBName) {
		this.exerciseCatBName = exerciseCatBName;
	}
	
	
}