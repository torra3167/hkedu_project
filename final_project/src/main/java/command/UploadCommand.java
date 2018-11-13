package command;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class UploadCommand implements Serializable {

	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseContent;
	private List<MultipartFile> uploadImage;
	private MultipartFile uploadVideo;
			
	
	public List<MultipartFile> getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(List<MultipartFile> uploadImage) {
		this.uploadImage = uploadImage;
	}
	public String getExerciseContent() {
		return exerciseContent;
	}
	public void setExerciseContent(String exerciseContent) {
		this.exerciseContent = exerciseContent;
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

	public MultipartFile getUploadVideo() {
		return uploadVideo;
	}
	public void setUploadVideo(MultipartFile uploadVideo) {
		this.uploadVideo = uploadVideo;
	}
	
	
	
	
	
	
	
	
	
	
}
