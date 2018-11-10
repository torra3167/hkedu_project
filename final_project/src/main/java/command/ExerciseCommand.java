package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class ExerciseCommand implements Serializable {

	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseName;
	private MultipartFile exerciseImg;
	private MultipartFile exerciseVideo;
	
	
	
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
	public MultipartFile getExerciseImg() {
		return exerciseImg;
	}
	public void setExerciseImg(MultipartFile exerciseImg) {
		this.exerciseImg = exerciseImg;
	}
	public MultipartFile getExerciseVideo() {
		return exerciseVideo;
	}
	public void setExerciseVideo(MultipartFile exerciseVideo) {
		this.exerciseVideo = exerciseVideo;
	}
	
	
	
}
