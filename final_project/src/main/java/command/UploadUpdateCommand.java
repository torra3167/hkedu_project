package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class UploadUpdateCommand implements Serializable {
	private int proNo;
	private int uploadNumber;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseCatAName;
	private String exerciseCatBName;
	private String exerciseContent;
	private int exerciseCal;
	private MultipartFile uploadFile;
	private String uploadOriginal;
	private String uploadStored;
	
	
	
	
	public int getExerciseCal() {
		return exerciseCal;
	}
	public void setExerciseCal(int exerciseCal) {
		this.exerciseCal = exerciseCal;
	}
	public String getExerciseCatAName() {
		return exerciseCatAName;
	}
	public void setExerciseCatAName(String exerciseCatAName) {
		this.exerciseCatAName = exerciseCatAName;
	}
	public String getExerciseCatBName() {
		return exerciseCatBName;
	}
	public void setExerciseCatBName(String exerciseCatBName) {
		this.exerciseCatBName = exerciseCatBName;
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public int getUploadNumber() {
		return uploadNumber;
	}
	public void setUploadNumber(int uploadNumber) {
		this.uploadNumber = uploadNumber;
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
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
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
	
	
	
	
}
