package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExerciseCommand implements Serializable {

	
	private String exerciseName;
	private String exerciseImg;
	private String exerciseVideo;
	
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
