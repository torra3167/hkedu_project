package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberExerciseOrderListCommand implements Serializable {
	private int proOrderNo;
	private String memberEmail;
	private int proNo;
	private String coachEmail;
	private int exerciseNumber;
	private int exerciseCatANumber;
	private int exerciseCatBNumber;
	private int exerciseCatCNumber;
	private String proOrderProduct;
	private int proOrderTotal;
	
	public MemberExerciseOrderListCommand() {
		
	}
	
	public int getProOrderNo() {
		return proOrderNo;
	}
	public void setProOrderNo(int proOrderNo) {
		this.proOrderNo = proOrderNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
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
	public int getExerciseCatCNumber() {
		return exerciseCatCNumber;
	}
	public void setExerciseCatCNumber(int exerciseCatCNumber) {
		this.exerciseCatCNumber = exerciseCatCNumber;
	}
	public String getProOrderProduct() {
		return proOrderProduct;
	}
	public void setProOrderProduct(String proOrderProduct) {
		this.proOrderProduct = proOrderProduct;
	}
	public int getProOrderTotal() {
		return proOrderTotal;
	}
	public void setProOrderTotal(int proOrderTotal) {
		this.proOrderTotal = proOrderTotal;
	}
}
