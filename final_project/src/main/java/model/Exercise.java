package model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Exercise implements Serializable {
	
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseContent;
	

	public Exercise(int exerciseNumber, int exerciseCatANumber, int exerciseCatBNumber, String exerciseContent) {
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
		this.exerciseContent = exerciseContent;
	}



	public Exercise() {}

	

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
	
	

	

}
