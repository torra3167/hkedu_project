package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class ExerciseCommand implements Serializable {

	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private MultipartFile exerciseFile;
	private Long exerciseSize;
	private String exerciseOriginal;
	private String exerciseStored;
	private String exerciseDivide;
	
	
	
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
	
	
	public MultipartFile getExerciseFile() {
		return exerciseFile;
	}
	public void setExerciseFile(MultipartFile exerciseFile) {
		this.exerciseFile = exerciseFile;
	}
	public Long getExerciseSize() {
		return exerciseSize;
	}
	public void setExerciseSize(Long exerciseSize) {
		this.exerciseSize = exerciseSize;
	}
	public String getExerciseOriginal() {
		return exerciseOriginal;
	}
	public void setExerciseOriginal(String exerciseOriginal) {
		this.exerciseOriginal = exerciseOriginal;
	}
	public String getExerciseStored() {
		return exerciseStored;
	}
	public void setExerciseStored(String exerciseStored) {
		this.exerciseStored = exerciseStored;
	}
	public String getExerciseDivide() {
		return exerciseDivide;
	}
	public void setExerciseDivide(String exerciseDivide) {
		this.exerciseDivide = exerciseDivide;
	}
	
	
	
	
	
}
