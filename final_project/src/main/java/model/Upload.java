package model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Upload implements Serializable {
	
	private int uploadNumber;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private Long uploadSize;
	private String uploadOriginal;
	private String uploadStored;
	private String uploadDivide;

	public Upload() {}

	
	
	
	public Upload(int exerciseNumber, int exerciseCatANumber, int exerciseCatBNumber) {
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
	}




	public Upload(int uploadNumber, Long uploadSize, String uploadOriginal, String uploadStored) {
		
		this.uploadNumber = uploadNumber;
		this.uploadSize = uploadSize;
		this.uploadOriginal = uploadOriginal;
		this.uploadStored = uploadStored;
	}




	public Upload(int uploadNumber, int exerciseNumber, int exerciseCatANumber, int exerciseCatBNumber, Long uploadSize,
			String uploadOriginal, String uploadStored) {
		
		this.uploadNumber = uploadNumber;
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
		this.uploadSize = uploadSize;
		this.uploadOriginal = uploadOriginal;
		this.uploadStored = uploadStored;
	}


	public Upload(int exerciseNumber, int exerciseCatANumber, int exerciseCatBNumber, Long uploadSize,
			String uploadOriginal, String uploadStored, String uploadDivide) {
		
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
		this.uploadSize = uploadSize;
		this.uploadOriginal = uploadOriginal;
		this.uploadStored = uploadStored;
		this.uploadDivide = uploadDivide;
	}


	
	public int getExerciseNumber() {
		return exerciseNumber;
	}


	public void setExerciseNumber(int exerciseNumber) {
		this.exerciseNumber = exerciseNumber;
	}


	public int getUploadNumber() {
		return uploadNumber;
	}

	public void setUploadNumber(int uploadNumber) {
		this.uploadNumber = uploadNumber;
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

	public Long getUploadSize() {
		return uploadSize;
	}

	public void setUploadSize(Long uploadSize) {
		this.uploadSize = uploadSize;
	}

	public String getUploadOriginal() {
		return uploadOriginal;
	}

	public void setUploadOriginal(String uploadOriginal) {
		this.uploadOriginal = uploadOriginal;
	}

	public String getUploadStored() {
		return uploadStored;
	}

	public void setUploadStored(String uploadStored) {
		this.uploadStored = uploadStored;
	}

	public String getUploadDivide() {
		return uploadDivide;
	}

	public void setUploadDivide(String uploadDivide) {
		this.uploadDivide = uploadDivide;
	}

	

}
