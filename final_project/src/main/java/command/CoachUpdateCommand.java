package command;

public class CoachUpdateCommand {
	private String coachEmail;
	private String coachPW;
	private String coachName;
	private String coachPhoto;
	private String coachCareer;
	private String coachDivide;
	
	public CoachUpdateCommand() {
		super();
	}
	
	public CoachUpdateCommand(String coachEmail, String coachPW, String coachName, String coachPhoto,
			String coachCareer, String coachDivide) {
		super();
		this.coachEmail = coachEmail;
		this.coachPW = coachPW;
		this.coachName = coachName;
		this.coachPhoto = coachPhoto;
		this.coachCareer = coachCareer;
		this.coachDivide = coachDivide;
	}
	
	public String getCoachEmail() {
		return coachEmail;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	public String getCoachPW() {
		return coachPW;
	}
	public void setCoachPW(String coachPW) {
		this.coachPW = coachPW;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public String getCoachPhoto() {
		return coachPhoto;
	}
	public void setCoachPhoto(String coachPhoto) {
		this.coachPhoto = coachPhoto;
	}
	public String getCoachCareer() {
		return coachCareer;
	}
	public void setCoachCareer(String coachCareer) {
		this.coachCareer = coachCareer;
	}
	public String getCoachDivide() {
		return coachDivide;
	}
	public void setCoachDivide(String coachDivide) {
		this.coachDivide = coachDivide;
	}
}
