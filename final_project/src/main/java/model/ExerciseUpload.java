package model;

public class ExerciseUpload {
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private Long exerciseUploadSize;
	private String exerciseUploadOriginal;
	private String exerciseUploadStored;
	private String exerciseUploadDivide;
	
	public ExerciseUpload() {}
	public ExerciseUpload(int exerciseNumber, Long exerciseUploadSize, String exerciseUploadOriginal,
			String exerciseUploadStored) {

		this.exerciseNumber = exerciseNumber;
		this.exerciseUploadSize = exerciseUploadSize;
		this.exerciseUploadOriginal = exerciseUploadOriginal;
		this.exerciseUploadStored = exerciseUploadStored;
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

	public Long getExerciseUploadSize() {
		return exerciseUploadSize;
	}

	public void setExerciseUploadSize(Long exerciseUploadSize) {
		this.exerciseUploadSize = exerciseUploadSize;
	}

	public String getExerciseUploadOriginal() {
		return exerciseUploadOriginal;
	}

	public void setExerciseUploadOriginal(String exerciseUploadOriginal) {
		this.exerciseUploadOriginal = exerciseUploadOriginal;
	}

	public String getExerciseUploadStored() {
		return exerciseUploadStored;
	}

	public void setExerciseUploadStored(String exerciseUploadStored) {
		this.exerciseUploadStored = exerciseUploadStored;
	}

	public String getExerciseUploadDivide() {
		return exerciseUploadDivide;
	}

	public void setExerciseUploadDivide(String exerciseUploadDivide) {
		this.exerciseUploadDivide = exerciseUploadDivide;
	}

}
