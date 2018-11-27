package command;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class ProgramCommand implements Serializable {

	private int proNo;
	private String proName;
	private MultipartFile proImg;
	private Date proRegdate;
	private String coachEmail;
	private String exerciseCatAName;
	private String proContent;
	private int proPrice;
	private String[] foodCatANos;
	private String[] foodCatANames;
	
	
	
	
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String[] getFoodCatANos() {
		return foodCatANos;
	}
	public void setFoodCatANos(String[] foodCatANos) {
		this.foodCatANos = foodCatANos;
	}
	public String[] getFoodCatANames() {
		return foodCatANames;
	}
	public void setFoodCatANames(String[] foodCatANames) {
		this.foodCatANames = foodCatANames;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public String getExerciseCatAName() {
		return exerciseCatAName;
	}
	public void setExerciseCatAName(String exerciseCatAName) {
		this.exerciseCatAName = exerciseCatAName;
	}
	public String getCoachEmail() {
		return coachEmail;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public MultipartFile getProImg() {
		return proImg;
	}
	public void setProImg(MultipartFile proImg) {
		this.proImg = proImg;
	}
	public Date getProRegdate() {
		return proRegdate;
	}
	public void setProRegdate(Date proRegdate) {
		this.proRegdate = proRegdate;
	}
	
	
}
