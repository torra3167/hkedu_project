package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SellerApplication implements Serializable{
	private int sellerAppliNo;
	private String sellerEmail;
	private String sellerAppliBn;
	private String sellerName;
	private String storeName;
	private String storeTelphone;
	private String storeAddr;
	private String storeTerm;
	private String applicationStatus;
	private String applicationDes;
	private Long sellerLicenseSize;
	private String sellerLicenseOriginal;
	private String sellerLicenseStored;
	private Long sellerBrSize;
	private String sellerBrOriginal;
	private String sellerBrStored;

	
	public SellerApplication() {
	}


	public SellerApplication(int sellerAppliNo, String sellerEmail, String sellerAppliBn, String sellerName,
			String storeName, String storeTelphone, String storeAddr, String storeTerm, String applicationStatus,
			String applicationDes, Long sellerLicenseSize, String sellerLicenseOriginal, String sellerLicenseStored,
			Long sellerBrSize, String sellerBrOriginal, String sellerBrStored) {
		this.sellerAppliNo = sellerAppliNo;
		this.sellerEmail = sellerEmail;
		this.sellerAppliBn = sellerAppliBn;
		this.sellerName = sellerName;
		this.storeName = storeName;
		this.storeTelphone = storeTelphone;
		this.storeAddr = storeAddr;
		this.storeTerm = storeTerm;
		this.applicationStatus = applicationStatus;
		this.applicationDes = applicationDes;
		this.sellerLicenseSize = sellerLicenseSize;
		this.sellerLicenseOriginal = sellerLicenseOriginal;
		this.sellerLicenseStored = sellerLicenseStored;
		this.sellerBrSize = sellerBrSize;
		this.sellerBrOriginal = sellerBrOriginal;
		this.sellerBrStored = sellerBrStored;
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


	public Long getSellerLicenseSize() {
		return sellerLicenseSize;
	}


	public void setSellerLicenseSize(Long sellerLicenseSize) {
		this.sellerLicenseSize = sellerLicenseSize;
	}


	public String getSellerLicenseOriginal() {
		return sellerLicenseOriginal;
	}


	public void setSellerLicenseOriginal(String sellerLicenseOriginal) {
		this.sellerLicenseOriginal = sellerLicenseOriginal;
	}


	public String getSellerLicenseStored() {
		return sellerLicenseStored;
	}


	public void setSellerLicenseStored(String sellerLicenseStored) {
		this.sellerLicenseStored = sellerLicenseStored;
	}


	public Long getSellerBrSize() {
		return sellerBrSize;
	}


	public void setSellerBrSize(Long sellerBrSize) {
		this.sellerBrSize = sellerBrSize;
	}


	public String getSellerBrOriginal() {
		return sellerBrOriginal;
	}


	public void setSellerBrOriginal(String sellerBrOriginal) {
		this.sellerBrOriginal = sellerBrOriginal;
	}


	public String getSellerBrStored() {
		return sellerBrStored;
	}


	public void setSellerBrStored(String sellerBrStored) {
		this.sellerBrStored = sellerBrStored;
	}
	
}
