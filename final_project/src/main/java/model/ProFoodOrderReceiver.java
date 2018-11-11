package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProFoodOrderReceiver implements Serializable{
	private int proFoodOrderReceiverNo;
	private String memberEmail;
	private String proFoodOrderReceiverName;
	private int proFoodOrderReceiverPhone;
	private String proFoodOrderReceiverAddr1;
	private String proFoodOrderReceiverAddr2;
	private int proFoodOrderReceiverAddrno;
	private int proFoodOrderReceiverTotal;
	public ProFoodOrderReceiver() {
	}
	public ProFoodOrderReceiver(int proFoodOrderReceiverNo, String memberEmail, String proFoodOrderReceiverName,
			int proFoodOrderReceiverPhone, String proFoodOrderReceiverAddr1, String proFoodOrderReceiverAddr2,
			int proFoodOrderReceiverAddrno, int proFoodOrderReceiverTotal) {
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
		this.memberEmail = memberEmail;
		this.proFoodOrderReceiverName = proFoodOrderReceiverName;
		this.proFoodOrderReceiverPhone = proFoodOrderReceiverPhone;
		this.proFoodOrderReceiverAddr1 = proFoodOrderReceiverAddr1;
		this.proFoodOrderReceiverAddr2 = proFoodOrderReceiverAddr2;
		this.proFoodOrderReceiverAddrno = proFoodOrderReceiverAddrno;
		this.proFoodOrderReceiverTotal = proFoodOrderReceiverTotal;
	}
	public int getProFoodOrderReceiverNo() {
		return proFoodOrderReceiverNo;
	}
	public void setProFoodOrderReceiverNo(int proFoodOrderReceiverNo) {
		this.proFoodOrderReceiverNo = proFoodOrderReceiverNo;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getProFoodOrderReceiverName() {
		return proFoodOrderReceiverName;
	}
	public void setProFoodOrderReceiverName(String proFoodOrderReceiverName) {
		this.proFoodOrderReceiverName = proFoodOrderReceiverName;
	}
	public int getProFoodOrderReceiverPhone() {
		return proFoodOrderReceiverPhone;
	}
	public void setProFoodOrderReceiverPhone(int proFoodOrderReceiverPhone) {
		this.proFoodOrderReceiverPhone = proFoodOrderReceiverPhone;
	}
	public String getProFoodOrderReceiverAddr1() {
		return proFoodOrderReceiverAddr1;
	}
	public void setProFoodOrderReceiverAddr1(String proFoodOrderReceiverAddr1) {
		this.proFoodOrderReceiverAddr1 = proFoodOrderReceiverAddr1;
	}
	public String getProFoodOrderReceiverAddr2() {
		return proFoodOrderReceiverAddr2;
	}
	public void setProFoodOrderReceiverAddr2(String proFoodOrderReceiverAddr2) {
		this.proFoodOrderReceiverAddr2 = proFoodOrderReceiverAddr2;
	}
	public int getProFoodOrderReceiverAddrno() {
		return proFoodOrderReceiverAddrno;
	}
	public void setProFoodOrderReceiverAddrno(int proFoodOrderReceiverAddrno) {
		this.proFoodOrderReceiverAddrno = proFoodOrderReceiverAddrno;
	}
	public int getProFoodOrderReceiverTotal() {
		return proFoodOrderReceiverTotal;
	}
	public void setProFoodOrderReceiverTotal(int proFoodOrderReceiverTotal) {
		this.proFoodOrderReceiverTotal = proFoodOrderReceiverTotal;
	}
	
	
}
