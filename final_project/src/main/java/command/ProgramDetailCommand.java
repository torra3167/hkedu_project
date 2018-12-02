package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramDetailCommand implements Serializable {
	
	private int proNo;
	private String proContent;
	private String proStored;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private String exerciseCatAName;
	private String exerciseCatBName;
	private int proPrice;
	private String proStatus;
	
	
	
	
	
	
	
	public String getProStored() {
		return proStored;
	}
	public void setProStored(String proStored) {
		this.proStored = proStored;
	}
	public String getProStatus() {
		return proStatus;
	}
	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
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
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public ProgramDetailCommand() {
	}
	public ProgramDetailCommand(int pro_no, String coachEmail, int exerciseNumber, int exerciseCatANumber,
			int exerciseCatBNumber) {
		this.proNo = pro_no;
		this.coachEmail = coachEmail;
		this.exerciseNumber = exerciseNumber;
		this.exerciseCatANumber = exerciseCatANumber;
		this.exerciseCatBNumber = exerciseCatBNumber;
	}
	
	
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getCoachEmail() {
		return coachEmail;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
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
	
	
	
	

}
