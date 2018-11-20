package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SellerApplication implements Serializable{
	private int sellerAppliNo;
	private String sellerEmail;
	private int sellerAppliBn;
	private String sellerLicense;
	private String sellerBusinessRegistration;
	private String sellerName;
	private String storeName;
	private int storeTelphone;
	private String storeAddr;
	private String storeTerm;
	private String applicationStatus;
	private String applicationDes;
	public SellerApplication() {
	}
	public SellerApplication(int sellerAppliNo, String sellerEmail, int sellerAppliBn, String sellerLicense,
			String sellerBusinessRegistration, String sellerName, String storeName, int storeTelphone, String storeAddr,
			String storeTerm, String applicationStatus, String applicationDes) {
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
	public int getSellerAppliBn() {
		return sellerAppliBn;
	}
	public void setSellerAppliBn(int sellerAppliBn) {
		this.sellerAppliBn = sellerAppliBn;
	}
	public String getSellerLicense() {
		return sellerLicense;
	}
	public void setSellerLicense(String sellerLicense) {
		this.sellerLicense = sellerLicense;
	}
	public String getSellerBusinessRegistration() {
		return sellerBusinessRegistration;
	}
	public void setSellerBusinessRegistration(String sellerBusinessRegistration) {
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
	public int getStoreTelphone() {
		return storeTelphone;
	}
	public void setStoreTelphone(int storeTelphone) {
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
