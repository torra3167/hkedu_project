package command;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class SellerApplicationWriteCommand implements Serializable{
	private int sellerAppliNo;
	private String sellerEmail;
	private String sellerAppliBn;
	private MultipartFile sellerLicense;
	private MultipartFile sellerBusinessRegistration;
	private String sellerName;
	private String storeName;
	private String storeTelphone;
	private String storeAddr;
	private String storeTerm;
	private String applicationStatus;
	private String applicationDes;
	public SellerApplicationWriteCommand() {
	}
	public SellerApplicationWriteCommand(int sellerAppliNo, String sellerEmail, String sellerAppliBn,
			MultipartFile sellerLicense, MultipartFile sellerBusinessRegistration, String sellerName, String storeName,
			String storeTelphone, String storeAddr, String storeTerm, String applicationStatus, String applicationDes) {
		this.sellerAppliNo = sellerAppliNo;
		this.sellerEmail = sellerEmail;
		this.sellerAppliBn = sellerAppliBn;
		this.sellerLicense = sellerLicense;
		this.sellerBusinessRegistration = sellerBusinessRegistration;
		this.sellerName = sellerName;
		this.storeName = storeName;
		this.storeTelphone = storeTelphone;
		this.storeAddr = storeAddr;
		this.storeTerm = storeTerm;
		this.applicationStatus = applicationStatus;
		this.applicationDes = applicationDes;
	}
	public int getSellerAppliNo() {
		return sellerAppliNo;
	}
	public void setSellerAppliNo(int sellerAppliNo) {
		this.sellerAppliNo = sellerAppliNo;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerAppliBn() {
		return sellerAppliBn;
	}
	public void setSellerAppliBn(String sellerAppliBn) {
		this.sellerAppliBn = sellerAppliBn;
	}
	public MultipartFile getSellerLicense() {
		return sellerLicense;
	}
	public void setSellerLicense(MultipartFile sellerLicense) {
		this.sellerLicense = sellerLicense;
	}
	public MultipartFile getSellerBusinessRegistration() {
		return sellerBusinessRegistration;
	}
	public void setSellerBusinessRegistration(MultipartFile sellerBusinessRegistration) {
		this.sellerBusinessRegistration = sellerBusinessRegistration;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreTelphone() {
		return storeTelphone;
	}
	public void setStoreTelphone(String storeTelphone) {
		this.storeTelphone = storeTelphone;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public String getStoreTerm() {
		return storeTerm;
	}
	public void setStoreTerm(String storeTerm) {
		this.storeTerm = storeTerm;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getApplicationDes() {
		return applicationDes;
	}
	public void setApplicationDes(String applicationDes) {
		this.applicationDes = applicationDes;
	}
	
	
}
