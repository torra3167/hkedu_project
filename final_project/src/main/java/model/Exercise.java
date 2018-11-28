package model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Exercise implements Serializable {
	
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseContent;
	private int exerciseCal;
	

	
	
	


	public Exercise(int exerciseNumber, int exerciseCatANumber, int exerciseCatBNumber, String exerciseContent,
			int exerciseCal) {
		super();
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
		this.exerciseContent = exerciseContent;
		this.exerciseCal = exerciseCal;
	}




	public Exercise() {}

	

	
	public int getExerciseCal() {
		return exerciseCal;
	}



	public void setExerciseCal(int exerciseCal) {
		this.exerciseCal = exerciseCal;
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
	
	

	

}
