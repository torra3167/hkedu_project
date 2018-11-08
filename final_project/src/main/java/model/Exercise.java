package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Exercise implements Serializable {
	
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseName;
	private String exerciseImg;
	private String exerciseVideo;
	
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
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getExerciseImg() {
		return exerciseImg;
	}
	public void setExerciseImg(String exerciseImg) {
		this.exerciseImg = exerciseImg;
	}
	public String getExerciseVideo() {
		return exerciseVideo;
	}
	public void setExerciseVideo(String exerciseVideo) {
		this.exerciseVideo = exerciseVideo;
	}
	
	
}
