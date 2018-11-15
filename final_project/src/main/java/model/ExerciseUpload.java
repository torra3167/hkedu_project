package model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ExerciseUpload implements Serializable {
	
	private int proNo;
	private String proContent;
	private Exercise exercise;
	private List<Upload> upload;
	
	

	public ExerciseUpload() {}

	public int getProNo() {
		return proNo;
	}

	public String getProContent() {
		return proContent;
	}

	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public List<Upload> getUpload() {
		return upload;
	}

	public void setUpload(List<Upload> upload) {
		this.upload = upload;
	}
	
	
	

	

}
