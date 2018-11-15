package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ExerciseUpload implements Serializable {
	
	private int proNo;
	private String proContent;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseContent;
	private List<Upload> uploads;
	
	

	public ExerciseUpload() {}



	public int getProNo() {
		return proNo;
	}



	public void setProNo(int proNo) {
		this.proNo = proNo;
	}



	public String getProContent() {
		return proContent;
	}



	public void setProContent(String proContent) {
		this.proContent = proContent;
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



	public List<Upload> getUploads() {
		return uploads;
	}



	public void setUploads(List<Upload> uploads) {
		this.uploads = uploads;
	}



	

	
	
	

	

}
