package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramExerciseUpload implements Serializable {
	private int proNo;
	private String proContent;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseContent;
	private int uploadNumber;
	private Long uploadSize;
	private String uploadOriginal;
	private String uploadStored;
	private String uploadDivide;
	
	
	
	public ProgramExerciseUpload() {
		
	}
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
	public int getUploadNumber() {
		return uploadNumber;
	}
	public void setUploadNumber(int uploadNumber) {
		this.uploadNumber = uploadNumber;
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
