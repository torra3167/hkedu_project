package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberSurvey implements Serializable {
	private int survNo;
	private String memberEmail;
	private int survHeight;
	private int survWeight;
	private String survEat;
	private int survBMI;
	private String survSex;
	private int survAge;
	private String survLifestyle;
	private String survPhoto;
	private String survShape;
	private String survDisease;
	private String survConcern;
	private String survCause;
	private String survCareer;
	
	public MemberSurvey() {
		
	}
	
	public int getSurvNo() {
		return survNo;
	}
	public void setSurvNo(int survNo) {
		this.survNo = survNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getSurvHeight() {
		return survHeight;
	}
	public void setSurvHeight(int survHeight) {
		this.survHeight = survHeight;
	}
	public int getSurvWeight() {
		return survWeight;
	}
	public void setSurvWeight(int survWeight) {
		this.survWeight = survWeight;
	}
	public String getSurvEat() {
		return survEat;
	}
	public void setSurvEat(String survEat) {
		this.survEat = survEat;
	}
	public int getSurvBMI() {
		return survBMI;
	}
	public void setSurvBMI(int survBMI) {
		this.survBMI = survBMI;
	}
	public String getSurvSex() {
		return survSex;
	}
	public void setSurvSex(String survSex) {
		this.survSex = survSex;
	}
	public int getSurvAge() {
		return survAge;
	}
	public void setSurvAge(int survAge) {
		this.survAge = survAge;
	}
	public String getSurvLifestyle() {
		return survLifestyle;
	}
	public void setSurvLifestyle(String survLifestyle) {
		this.survLifestyle = survLifestyle;
	}
	public String getSurvPhoto() {
		return survPhoto;
	}
	public void setSurvPhoto(String survPhoto) {
		this.survPhoto = survPhoto;
	}
	public String getSurvShape() {
		return survShape;
	}
	public void setSurvShape(String survShape) {
		this.survShape = survShape;
	}
	public String getSurvDisease() {
		return survDisease;
	}
	public void setSurvDisease(String survDisease) {
		this.survDisease = survDisease;
	}
	public String getSurvConcern() {
		return survConcern;
	}
	public void setSurvConcern(String survConcern) {
		this.survConcern = survConcern;
	}
	public String getSurvCause() {
		return survCause;
	}
	public void setSurvCause(String survCause) {
		this.survCause = survCause;
	}
	public String getSurvCareer() {
		return survCareer;
	}
	public void setSurvCareer(String survCareer) {
		this.survCareer = survCareer;
	}
}
